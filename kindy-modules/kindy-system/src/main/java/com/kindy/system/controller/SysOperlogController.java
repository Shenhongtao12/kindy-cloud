package com.kindy.system.controller;

import org.ietf.jgss.Oid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operlog")
public class SysOperlogController {

    @PostMapping
    public void addLog(Object operLog) {
        System.out.println("记录log： " + operLog.toString());
    }
}
