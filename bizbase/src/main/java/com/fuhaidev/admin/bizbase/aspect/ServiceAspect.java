package com.fuhaidev.admin.bizbase.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by xumingxun on 2018/5/14.
 */
@Aspect
@Component
public class ServiceAspect{

    @Autowired
    @Qualifier("paramValidateServiceFilter")
    ServiceFilter serviceFilter;

    @Around("target(com.fuhaidev.admin.bizbase.service.AbstractService)")
    public Object proceed(ProceedingJoinPoint pjp) throws Throwable {
        Object result=serviceFilter.proceed(pjp);
        return result;
    }

}
