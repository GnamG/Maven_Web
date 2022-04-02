package com.fc.test;

import com.fc.controller.UserController;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        User bean = applicationContext.getBean(User.class);
        UserController controller = applicationContext.getBean(UserController.class);
        List<User> list = controller.findAll();
        System.out.println(list);
        System.out.println(bean);

    }
    @Test
    public void testAnnotation(){
      // 通过注解获取Spring容器
      // 必须配置扫描路径
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.fc");

    User bean = applicationContext.getBean(User.class);
    System.out.println(bean);

    }
    @Test
    public void testUser(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        applicationContext.close();
    }
}
