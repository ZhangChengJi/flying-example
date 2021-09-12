package com.flying.client.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RefreshScope
@RestController
public class UserController {

    @Value("${abc}")
    private String abc;
    @Resource
    private UserProperties user;

    @GetMapping("/user")
    public UserProperties getUser() {
        System.out.println("打印user信息:"+this.user);
        return this.user;
    }
    public String getAbc(){
        System.out.println("打印26字母"+ this.abc);
        return this.abc;
    }
}
