package com.fc.controller;

import com.fc.exception.SingletonDogException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exception")
public class ExceptionController {
    @RequestMapping("system")
    public void testSystemException(@RequestParam Integer id){
        int num = 1/0;
    }

    @RequestMapping("singleton")
    public void testCustomException() throws SingletonDogException {
        throw new SingletonDogException("单身狗异常");
    }

}
