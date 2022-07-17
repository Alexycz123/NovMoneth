package com.ycz.config;/*
 @author ycz
 @date 2021-11-23-19:49
*/

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfig.class)
public class MybatisConfig {

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource){

        TransactionFactory transactionFactory=new JdbcTransactionFactory();

        Environment environment=new Environment("1",transactionFactory,dataSource);
        org.apache.ibatis.session.Configuration configuration=
                new org.apache.ibatis.session.Configuration(environment);
        
        return new DefaultSqlSessionFactory(configuration);
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.ycz.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }


}
