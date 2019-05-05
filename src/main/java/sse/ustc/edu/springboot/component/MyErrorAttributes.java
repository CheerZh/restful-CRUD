package sse.ustc.edu.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author ZHGQ
 * @project TIMSServer
 * @Package sse.sse.edu.springboot.component
 * @date 2019/3/3-16:52
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description: for...
 */

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回的map就是json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","ustc");

        //异常处理器携带的数据
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext",ext);

        return map;
    }
}
