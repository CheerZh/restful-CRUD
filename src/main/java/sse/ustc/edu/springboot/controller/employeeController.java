package sse.ustc.edu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sse.ustc.edu.springboot.dao.DepartmentDao;
import sse.ustc.edu.springboot.dao.EmployeeDao;
import sse.ustc.edu.springboot.entities.Department;
import sse.ustc.edu.springboot.entities.Employee;


import java.util.Collection;

/**
 * @author ZHGQ
 * @project TIMSServer
 * @Package sse.sse.edu.springboot.controller
 * @date 2019/3/1-23:12
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description: for...
 */

@Controller
public class employeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){  //Model\Map\ModelMap都在请求域中
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);

        //thymeleaf默认拼串
        //classpath:/templates/xxxx.html
        return "emp/list";
    }

    //转到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){

        //查出所有的部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //添加页面
        return "emp/add";
    }

    //员工添加功能
    //springMVC自动将请求参数和入参对象的属性进行一一绑定
    //要求请求参数的名字和JavaBean入参对象的属性名相同
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("保存的员工信息："+employee);
        //保存员工信息
        employeeDao.save(employee);

        //redirect重定向    /代表当前项目路径
        //forward转发
        return "redirect:/emps";
    }

    //来到修改页面，查出当前员工，再页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){

        Employee employee = employeeDao.get(id);
        //页面回显部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departments);

        //回到修改页面（add作为修改添加二合一的页面）
        return "/emp/add";
    }

    //员工修改;需要提交员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){

        employeeDao.save(employee);

        System.out.println("修改员工的数据："+employee);
        return "redirect:/emps";

    }

    //员工删除
    @DeleteMapping("emp/{id}")
    public String delectEmployee(@PathVariable("id") Integer id){

        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
