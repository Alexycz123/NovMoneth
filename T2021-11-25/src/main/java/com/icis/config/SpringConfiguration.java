package com.icis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

// 总配置类
@Configuration
// 引入其他的配置  @Import
@Import(value = {SpringJdbc.class,SpringJsonMapper.class})
@ComponentScan("com.icis")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
