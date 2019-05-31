package com.yangyh.mybatis.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.yangyh.mybatis.learn.mapper")
public class MybatisLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisLearnApplication.class, args);
    }

}
