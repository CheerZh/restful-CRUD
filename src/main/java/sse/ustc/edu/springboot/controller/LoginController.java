package sse.ustc.edu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ZHGQ
 * @project TIMSServer
 * @Package sse.sse.edu.springboot.controller
 * @date 2019/3/1-17:42
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description: for...
 */

@Controller
public class LoginController {

//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
//    @DeleteMapping
//    @PutMapping
//    @GetMapping
    @PostMapping(value="/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){

            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        map.put("message","用户名密码错误");
        return "login";
    }
}
