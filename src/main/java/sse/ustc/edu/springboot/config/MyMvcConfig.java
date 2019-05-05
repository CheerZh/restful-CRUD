package sse.ustc.edu.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sse.ustc.edu.springboot.component.LoginHandlerInterceptor;


/**
 * @author ZHGQ
 * @project TIMSServer
 * @Package sse.sse.edu.springboot.config
 * @date 2019/2/28-20:23
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description: for...
 */

//实现WebMvcConfigurer接口，扩展SpringMVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/atguigu 请求来到 success
//        registry.addViewController("/atguigu").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/hello","/error","/login.html",
                        "/asserts/css/**","/asserts/img/**","/asserts/js/**","/webjars/**");

    }
}
