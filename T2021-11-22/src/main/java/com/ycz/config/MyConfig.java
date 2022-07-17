package com.ycz.config;/*
 @author ycz
 @date 2021-11-23-10:40
*/

import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.ycz")
@Import({DataSourceConfig.class,MybatisConfig.class})
public class MyConfig {

    @Bean(name = "getTemplate")
    public JdbcTemplate getJdbcTemplate(@Qualifier("druidDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    public SqlSession getSqlSession(){
        return MybatisUtils.getSqlSession();
    }

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }



}
