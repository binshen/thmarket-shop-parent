package com.thmarket.api.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="thmarket-user-service")
public interface UserRemote {

    @RequestMapping("/user")
    public String getUserById(@RequestParam int userId);
}
