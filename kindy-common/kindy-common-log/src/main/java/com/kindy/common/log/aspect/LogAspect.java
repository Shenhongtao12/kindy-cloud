package com.kindy.common.log.aspect;

import com.kindy.common.log.annotation.Log;
import com.kindy.common.log.service.AsyncLogService;
import com.kindy.system.api.domain.SysOperLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private AsyncLogService asyncLogService;

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Log controllerLog, Object jsonResult)
    {
        handleLog(joinPoint, controllerLog, null, jsonResult);
    }

    protected void handleLog(final JoinPoint joinPoint, Log controllerLog, final Exception e, Object jsonResult) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("===========");
        System.out.println(className + "." + methodName);

        SysOperLog operLog = new SysOperLog();
        operLog.setTitle(className + methodName);
        try {
            asyncLogService.saveSysLog(operLog);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}