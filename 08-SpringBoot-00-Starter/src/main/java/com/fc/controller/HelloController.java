package com.fc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 开启自动装配
@RequestMapping("user")
public class HelloController {

    @RequestMapping("hello")
    String home() {
        return "Hello World!";
    }


}
