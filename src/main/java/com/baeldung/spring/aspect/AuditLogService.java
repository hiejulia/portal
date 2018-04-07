package com.baeldung.spring.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AuditLogService {

    private static Logger mainLogger = LoggerFactory.getLogger(AuditLogService.class);

    // Log : dao
    @Before("execution(* com.baeldung.spring.dao.impl.*.*(..)) && target(service)")
    public void log(Object service) {
        mainLogger.info("Accessing {}" + service.getClass().getSimpleName());

    }
}


