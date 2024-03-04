package com.example.insurancemicroservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUsername("dean");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("com.example.insurancemicroservice.domain");
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(properties());
        return entityManagerFactory;
    }

    Properties properties(){
        Properties properties = new Properties();
      //  properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_SQL", "true");
        return properties;
    }
}

/*
Task 3 - Once payment is completed,
send an email to the user with a link to upload the documents.
 A user will upload the document.
 Create a admin page to display all the insurance request,
 he will verify all the document and
 if he feels everything is fine he will approve the policy and
 then email will trigger on the registered email id with policy document
 */
