package com.fc.test;

import com.fc.config.AopConfig;
import com.fc.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);

        UserService service = applicationContext.getBean(UserService.class);

        service.add();
        service.update();
    }
}
