package com.fc.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


// 切面类，用于指定增强的方法
@Aspect
public class AnnotationAdvice {

    @Pointcut("execution(* com.fc.service.impl.*ServiceDaoImpl.*(..))")
    public static void pointcut(){}

    // 前置通知
    @Before("AnnotationAdvice.pointcut()")
    public void before(){
        System.out.println("执行前通知");
    }

    // 后置通知
    @AfterReturning("AnnotationAdvice.pointcut()")
    public void afterReturning(){
        System.out.println("后置通知，异常不触发");
    }
    @After("AnnotationAdvice.pointcut()")
    public void after(){
        System.out.println("最终通知!");
    }
    @AfterThrowing("AnnotationAdvice.pointcut()")
    public void afterThrowing(){
        System.out.println("异常问题:出现异常");
    }
    @Around("AnnotationAdvice.pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("环绕通知,方法调用之前执行");

        Object proceed = joinPoint.proceed();

        System.out.println("环绕通知，方法调用之后");
        return proceed;
    }
}
