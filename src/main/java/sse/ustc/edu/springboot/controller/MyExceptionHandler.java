package sse.ustc.edu.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sse.ustc.edu.springboot.exception.UserNotExistException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHGQ
 * @project TIMSServer
 * @Package sse.ustc.edu.springboot.controller
 * @date 2019/3/3-15:14
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description: for...
 */

@ControllerAdvice
public class MyExceptionHandler {

    //1、浏览器服务器返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handleException(Exception e){
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){

        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map = new HashMap<>();
        map.put("exception","sse.sse.springboot.controller.UserNotExistException");
        map.put("code","user.notexist");
        map.put("message",e.getMessage());

        request.setAttribute("ext",map);
        return "forward:/error";

    }


}
