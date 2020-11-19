package com.jskj.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

/**
 * @author lintao
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GetawayMain9527 {
    public static void  main(String[] args){
        SpringApplication.run(GetawayMain9527.class,args);
    }

}
