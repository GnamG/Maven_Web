package com.fc.controller;

import com.fc.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exception")
public class ExceptionController {
    // 测试系统异常
    @RequestMapping("system")
    public String testSystemException() {
        int i = 1 / 0;
        return "/error/500.html";
    }

    // 测试自定义异常
    @RequestMapping("custom")
    public void testCustomException() throws MyException {
        throw new MyException("自定义异常");
    }
}
