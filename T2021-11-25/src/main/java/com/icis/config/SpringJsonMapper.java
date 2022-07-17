package com.icis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

public class SpringJsonMapper {

    // 创建一个  ObjectMapper
    @Bean
    public ObjectMapper getMapper(){
        return  new ObjectMapper();
    }
}
