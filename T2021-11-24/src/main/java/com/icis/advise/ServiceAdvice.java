package com.icis.advise;/*
 @author ycz
 @date 2021-11-24-15:19
*/

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ServiceAdvice {

    @Before(value = "execution(* com.icis.service.impl.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("日志的前置通知");
        System.out.println("获取的方法名"+joinPoint.getSignature().getName());
        System.out.println("获取的方法参数"+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "execution(* com.icis.service.impl.*.*(..))")
    public void AfterAdvice(JoinPoint joinPoint){
        System.out.println("日志的后置通知");
        System.out.println("获取的方法名"+joinPoint.getSignature().getName());
        System.out.println("获取的方法参数"+ Arrays.toString(joinPoint.getArgs()));
    }

}
