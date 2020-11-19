package com.jskj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lintao
 */
@SpringBootApplication
@EnableRedisHttpSession
@EnableDiscoveryClient
public class StaticMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(StaticMain9001.class,args);
    }
    //这里配置静态资源文件的路径导包都是默认的直接导入就可以

}
