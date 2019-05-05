package sse.ustc.edu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sse.ustc.edu.springboot.exception.UserNotExistException;


import java.util.Arrays;
import java.util.Map;

/**
 * @author ZHGQ
 * @project TIMSServer
 * @Package sse.sse.edu.springboot.controller
 * @date 2019/2/27-14:37
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description: for...
 */

@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){

        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello world";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","Lisi","Wangwu"));

        //classpath:/templates/success.html
        return "success";
    }

//    @RequestMapping({"/","/login.html"})
//    public String index(){
//        return "index";
//    }
}
