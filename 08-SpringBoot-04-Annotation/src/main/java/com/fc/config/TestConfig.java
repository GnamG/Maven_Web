package com.fc.config;

import com.fc.entity.Car;
import com.fc.entity.Cat;
import com.fc.entity.Person;
import com.fc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

// 声明当前类是一个配置类，相当于xml文件，会在Springboot启动时加载
// proxyBeanMethods属性默认为true，代表使用cglib动态代理生成bean对象
@Configuration(proxyBeanMethods = false)
@Import(Cat.class)
public class TestConfig {
    @Bean({"car","car1"})
    public Car getCar(){
        return new Car("奥迪RS7","灰色");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化~~~");
    }

    @Bean("person")
    public Person getPerson(){
        return new Person("pp",getCar());
    }

    @Bean
    public User getUser(){
        return new User();
    }

    public TestConfig(){
        System.out.println("构造方法被执行！");
    }

    public String test(){
        System.out.println("测试方法被执行·~");
        return "测试";
    }

}
