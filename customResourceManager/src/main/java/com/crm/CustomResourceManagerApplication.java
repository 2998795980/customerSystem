package com.crm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.crm.dao.mapper")
public class CustomResourceManagerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CustomResourceManagerApplication.class, args);
    }
}
