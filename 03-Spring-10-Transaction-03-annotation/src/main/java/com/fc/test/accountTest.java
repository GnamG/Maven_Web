package com.fc.test;

import com.fc.config.TxtConfig;
import com.fc.service.AccountService;
import com.fc.service.impl.AnnotationServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class accountTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService accountService = applicationContext.getBean(AnnotationServiceImpl.class);

        accountService.transfer(1,2,500L);
    }
    @Test
    public void testAnnotation(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxtConfig.class);

        AccountService bean = applicationContext.getBean("annotationServiceImpl", AccountService.class);

        bean.transfer(1,2,500L);
    }
}
