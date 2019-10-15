package com.zou.huzhu2biz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 17:46
 * Project:  huzhu
 * Description:
 **/
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.zou.huzhu2biz.service.impl.*.*(..))")
    public void log(){}

    @Around(value = "log()")
    public Object processTimeLog(ProceedingJoinPoint pjp){
        try {
            long start = System.currentTimeMillis();
            Object o = pjp.proceed();
            String className = pjp.getTarget().getClass().getSimpleName();
            String methodName = pjp.getSignature().getName();
            long end = System.currentTimeMillis();
            logger.debug("{}.{} 执行用时:{}ms",className,methodName,(end-start));
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
