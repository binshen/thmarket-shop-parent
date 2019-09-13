package com.thmarket.service.api;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    @ApolloConfig
    private Config config;

    @Value("${userName}")
    private String userName;

    @RequestMapping("/user")
    public String getUserById(@RequestParam int userId) {

        return "hello, " + userId + ", Apollo: " + config.getProperty("userAge", "25") + ". This is built by " + userName;
    }
}
