package com.kindy.system.controller;

import com.kindy.common.log.annotation.Log;
import com.kindy.system.api.domain.SysOperLog;
import org.ietf.jgss.Oid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operlog")
public class SysOperlogController {

    @PostMapping
    public void addLog(SysOperLog operLog) {
        System.out.println("记录log： " + operLog.toString());
    }

    @GetMapping
    public String forward() {
        return "================-------------------";
    }
}
