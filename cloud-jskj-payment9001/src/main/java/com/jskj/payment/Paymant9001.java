package com.jskj.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lintao
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Paymant9001 {
    public static void main(String[] args) {
        SpringApplication.run(Paymant9001.class,args);
    }
}
