package com.fc;

import com.fc.entity.GirlFriend;
import com.fc.entity.Son;
import com.fc.entity.Wife;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // 获取spring容器

        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        if (applicationContext.containsBean("son")){
            Son son = applicationContext.getBean(Son.class);
            System.out.println("有儿子"+ son);
        } else {
            System.out.println("没儿子");
        }
        if (applicationContext.containsBean("wife")){
            Wife wife = applicationContext.getBean(Wife.class);
            System.out.println("有老婆"+ wife);
        } else {
            System.out.println("没老婆");
        }
        if (applicationContext.containsBean("GirlFriend")){
            GirlFriend girlFriend = applicationContext.getBean(GirlFriend.class);
            System.out.println("有女友"+ girlFriend);
        } else {
            System.out.println("没女友");
        }

        System.out.println(applicationContext.getBean("car"));

    }

}
