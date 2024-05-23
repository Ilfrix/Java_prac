package org.example;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Before("allServiceMethods()")
    public void logParameters(JoinPoint joinPoint) {
        log.info("Parameters: {}", joinPoint.getArgs());
    }

    @Pointcut("within(demo.services.*)")
    public void allServiceMethods() {}
}

