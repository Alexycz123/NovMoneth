package com.ycz.config;/*
 @author ycz
 @date 2021-11-29-8:57
*/

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Import(value = DataSourceConfig.class)
//@Configuration
public class JdbcTemplateConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(@Qualifier("myDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
