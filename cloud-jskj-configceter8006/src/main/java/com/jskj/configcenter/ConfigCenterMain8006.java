package com.jskj.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lintao
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigCenterMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain8006.class,args);
    }
}
