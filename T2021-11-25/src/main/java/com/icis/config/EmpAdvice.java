package com.icis.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 员工模块的通知类  增强  tx 事务 aop 需要手动开启  默认关闭 Enable
@Aspect
@Component // 通知类 必须让入到spring容器中
public class EmpAdvice {
    @Pointcut("execution(* com.icis..service.impl.*.*(..))")
    public void pointCut(){}


    /*@Before(value = "pointCut()")
    public void beforePrintLog(){
        System.out.println("查询前...根据id 查询员工了....记录日志 Before");
    }
    @AfterReturning(value = "pointCut()")
    public void afterReturningPrintLog(){
        System.out.println("查询后...开始根据id 查询员工了....记录日志afterReturning");
    }
    @AfterThrowing(value = "pointCut()")
    public void  afterThrowingPrintLog(){
        System.out.println("查询后异常...开始根据id 查询员工了....记录日志afterThrowing");
    }
    @After(value = "pointCut()")
    public void afterPrintLog(){
        System.out.println("不管有没有查询成功,都要执行...开始根据id 查询员工了....记录日志after");
    }*/
    // 需要手动编程   针对切入点
    /*
    * ProceedingJoinPoint Spring 会创建接口实现类 实现数据注入
    *
    * */
    @Around(value = "pointCut()")
    public Object aroundPrintLog(ProceedingJoinPoint joinPoint){
        // 执行方法
        // 获得参数
        Object obj=null;
        try {
            System.out.println("前置通知  around");
            Object[] args = joinPoint.getArgs();

        String methodName = joinPoint.getSignature().getName();
        System.out.println("拦截到方法"+methodName+"获得参数:"+ Arrays.toString(args));
           obj= joinPoint.proceed(args);
            System.out.println("后置通知  around");
        } catch (Throwable throwable) {
            System.out.println("异常通知  around");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知  around");
        }

        return obj;


    }


}
