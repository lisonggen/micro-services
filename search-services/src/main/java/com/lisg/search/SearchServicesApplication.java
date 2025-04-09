package com.lisg.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


// Generated by https://start.springboot.io
// 优质的 spring/boot/data/security/cloud 框架中文文档尽在 => https://springdoc.cn
@EnableFeignClients(basePackages = "com.lisg.goods.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class SearchServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchServicesApplication.class, args);
    }

}
