package com.kindy.common.log.service;

import com.kindy.system.api.domain.SysOperLog;
import com.kindy.system.api.service.RemoteLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncLogService {

    @Autowired
    private RemoteLogService remoteLogService;

    @Async
    public void saveSysLog(SysOperLog sysOperLog) throws Exception {
        remoteLogService.saveLog(sysOperLog, "inner");
    }
}
