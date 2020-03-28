package com.tsc.iorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tsc.iorder.dao")
public class IorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(IorderApplication.class, args);
    }

}
