package com.kindy.system.controller;

import com.kindy.common.log.annotation.Log;
import org.ietf.jgss.Oid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operlog")
public class SysOperlogController {

    @Log(title = "log")
    @PostMapping
    public void addLog(Object operLog) {
        System.out.println("记录log： " + operLog.toString());
    }

    @GetMapping
    public String forward() {
        return "================-------------------";
    }
}
