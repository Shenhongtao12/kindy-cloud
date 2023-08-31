package com.kindy.system.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
    @SentinelResource(value = "hello", blockHandler = "handleBlock", fallback = "fallback")
    public String get() throws InterruptedException {
//        throw new RuntimeException("error");
        Thread.sleep(100);
        System.out.println(systemConfig.getUsername());
        return "user " +  System.currentTimeMillis() + " : " + systemConfig.getUsername();
    }

    public String fallback() {
        return "================";
    }

    public String handleBlock(BlockException ex) {
        // 限流处理逻辑
        System.out.println("Sorry, too many requests!");
        return "Sorry, too many requests!";
    }
}
