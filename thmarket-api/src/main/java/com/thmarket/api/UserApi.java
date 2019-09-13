package com.thmarket.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thmarket.api.remote.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    @Autowired
    private UserRemote userRemote;

    @RequestMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "getUserFallback")
    public String getUserById(@PathVariable("id") int userId) {

        return userRemote.getUserById(userId);
    }

    String getUserFallback(int userId) {
        return "服务器故障，请稍后重试";
    }
}
