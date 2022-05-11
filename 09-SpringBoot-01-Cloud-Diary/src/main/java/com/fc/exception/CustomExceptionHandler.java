package com.fc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

// 异常处理器
@RestControllerAdvice
public class CustomExceptionHandler {
    // 此注解用于处理对应异常类型的异常
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerSystemException(Exception e, HttpServletRequest req) {
        Map<String, Object>map = new HashMap<>();
        map.put("msg",e.getMessage());
        map.put("url",req.getRequestURL());
        return map;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handlerSystem(Exception e, HttpServletRequest req) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg",e.getMessage());
        map.put("url",req.getRequestURL());
        return map;
    }
}
