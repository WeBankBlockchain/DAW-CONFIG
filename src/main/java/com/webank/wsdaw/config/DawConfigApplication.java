package com.webank.wsdaw.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = "com.webank.wsdaw.config.dao.mapper")
public class DawConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(DawConfigApplication.class, args);
    }
}
