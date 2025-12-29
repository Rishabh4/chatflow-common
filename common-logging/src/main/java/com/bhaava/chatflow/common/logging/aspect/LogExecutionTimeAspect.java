package com.bhaava.chatflow.common.logging.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class LogExecutionTimeAspect {

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        log.info("Executed {} in {} ms",
                joinPoint.getSignature(), duration);

        return result;
    }
}
