package com.fuhaidev.admin.bizbase.aspect.impl;

import com.fuhaidev.admin.bizbase.aspect.ServiceFilter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by xumingxun on 2018/5/14.
 */
@Component
public class MasterSlaveServiceFilter extends AbstractServiceFilter{

    @Autowired
    @Qualifier("logServiceFilter")
    ServiceFilter serviceFilter;

    @Override
    public Object proceed(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        //db主从切换
//        DbContextHolder.setDbType(DbContextHolder.DbType.MASTER);
//        if (method.isAnnotationPresent(Slave.class)) {
//            DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
//        }

        return serviceFilter.proceed(pjp);
    }
}
