package com.ycz.config;/*
 @author ycz
 @date 2021-11-29-8:51
*/

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@Import(value = {JdbcTemplateConfig.class,SpringTxConfig.class})
//@ComponentScan(basePackages = "com.ycz")
//@EnableAspectJAutoProxy //开启aop支持
//@EnableTransactionManagement //开启spring对事物控制
public class SpringConfig {
}
