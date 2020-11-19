package com.jskj.logistics;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * @author lintao
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
@SpringBootApplication
@EnableDiscoveryClient
public class LogisticsMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsMain8003.class,args);
    }
}
