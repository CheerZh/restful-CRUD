package sse.ustc.edu.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZHGQ
 * @project TIMSServer
 * @Package sse.sse.edu.springboot.component
 * @date 2019/3/1-20:54
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description: 登陆检查
 */

//继承HandlerInterceptor,实现未完成的方法
    //preHandle
    //postHandle
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user=request.getSession().getAttribute("loginUser");
        if(user == null){
            //未登录
            request.setAttribute("message","没有权限，请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;

        }else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
