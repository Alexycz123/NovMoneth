package com.icis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@PropertySource(value = "classpath:db.properties")
public class SpringJdbc {
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;



    // 定义方法 创建数据源
    @Bean(name = "druidDs")
    public DataSource getDruidDs2(){
        DruidDataSource ds=new DruidDataSource();
        // 设置数据库连接属性
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        return  ds;
    }


    @Bean(name = "dbcpDs")
    public DataSource getDruidDs3(){
        BasicDataSource ds=new BasicDataSource();
        // 设置数据库连接属性
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        return  ds;
    }
    @Bean
    public JdbcTemplate getTemplate(@Qualifier("dbcpDs") DataSource ds){
        return  new JdbcTemplate(ds);
    }
}
