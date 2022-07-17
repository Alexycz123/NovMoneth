package com.ycz.advise;/*
 @author ycz
 @date 2021-11-24-15:19
*/

import org.springframework.stereotype.Component;

@Component
public class ServiceAdvice {

    public void beforeAdvice(){
        System.out.println("日志的前置通知");
    }

}
