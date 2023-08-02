package com.kindy.system.controller;

import com.kindy.common.log.annotation.Log;
import com.kindy.system.config.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kindy/user")
public class UserController {

    @Autowired
    private SystemConfig systemConfig;

    @Log(title = "user测试")
    @GetMapping
    public String get() throws InterruptedException {
        System.out.println(systemConfig.getUsername());
        return "user " +  System.currentTimeMillis() + " : " + systemConfig.getUsername();
    }
}
