package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data

@AllArgsConstructor
@Component
@Scope("prototype")
public class User {
    @Value("1")
    private Integer id;
    @Value("qq")
    private String username;
    @Value("321")
    private String password;

    public User() {
        System.out.println("无参构造被执行");
    }

    // 在构造方法后执行
    @PostConstruct
    public void eat(){
        System.out.println("就知道吃");
    }

    // 之前销毁
    @PreDestroy
    public void sleep(){
        System.out.println("吃完就睡");
    }

}
