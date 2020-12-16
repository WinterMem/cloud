package com.pch.gateway.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.common.util.SpringContextHolder;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${test:}")
    private String username;

    @RequestMapping("/username")
    public String get() {
        Object routeQueue = SpringContextHolder.getBean("userRepository");
        return username;
    }

}
