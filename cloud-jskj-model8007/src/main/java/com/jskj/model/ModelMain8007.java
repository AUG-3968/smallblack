package com.jskj.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author lintao
 */
@SpringBootApplication
@EnableRedisHttpSession
@EnableDiscoveryClient
public class ModelMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(ModelMain8007.class,args);
    }
}
