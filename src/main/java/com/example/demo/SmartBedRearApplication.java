package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})  // 确保扫描到你的配置类
public class SmartBedRearApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartBedRearApplication.class, args);
    }

}
