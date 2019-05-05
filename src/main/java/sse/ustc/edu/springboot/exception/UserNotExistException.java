package sse.ustc.edu.springboot.exception;

/**
 * @author ZHGQ
 * @project spring-boot-04-web-restfulcrud
 * @Package sse.sse.springboot.exception
 * @date 2019/3/3-14:57
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description: for...
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
