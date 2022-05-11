package com.fc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(SingletonDogException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerSystem(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-4000);
        map.put("message","发生了danshen异常");
        map.put("success",false);
        map.put("exception",e.getMessage());
        return map;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public Map<String, Object> handlerCustom(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-4000);
        map.put("message","发生了异常");
        map.put("success",false);
        map.put("exception",e.getMessage());
        return map;
    }
}
