package com.ycz.pojo;/*
 @author ycz
 @date 2021-11-29-9:46
*/

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountAspect {

    @Pointcut(value = "execution(* com.ycz.service.impl.AccountServiceImpl.getOne(..))")
    public void pointcut(){};

    @Around(value = "pointcut()")
    public Object AccountAround(ProceedingJoinPoint joinPoint){
        Object returnObj = null;

        try {
            String methodName=joinPoint.getSignature().getName();
            System.out.println("开始记录时间查询");
            long beginTime = System.currentTimeMillis();
            returnObj=joinPoint.proceed();
            long lastTime = System.currentTimeMillis();
            System.out.println("花费了"+(lastTime-beginTime));
            System.out.println("查询结束");
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return returnObj;
    }

}
