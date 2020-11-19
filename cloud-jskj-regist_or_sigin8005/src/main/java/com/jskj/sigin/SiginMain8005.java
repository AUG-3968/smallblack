package com.jskj.sigin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import sun.applet.Main;

/**
 * @author lintao
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
@SpringBootApplication
@EnableDiscoveryClient
public class SiginMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(SiginMain8005.class,args);
    }
}
