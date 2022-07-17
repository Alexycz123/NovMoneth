package com.ycz.config;/*
 @author ycz
 @date 2021-11-29-11:23
*/

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Import(value = DataSourceConfig.class)
public class SpringTxConfig {

    @Bean
    public PlatformTransactionManager getPlatformTransactionManager
            (@Qualifier("myDataSource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


}
