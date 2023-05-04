package com.epam.esm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context
        .annotation.ComponentScan;
import org.springframework.context
        .annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.epam.esm")
public class MVCconfig {


    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rest_task");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        return dataSource;
    }




}
