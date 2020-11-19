package com.jskj.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lintao
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverpot;

    @GetMapping(value = "/payment/nacos/id")
    public String getPayment(){
        return serverpot;
    }
}
