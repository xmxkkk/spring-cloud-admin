package com.fuhaidev.admin.bizbase.aspect.impl;

import com.fuhaidev.admin.api.common.DataResult;
import com.fuhaidev.admin.bizbase.aspect.ServiceFilter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by xumingxun on 2018/5/14.
 */
@Component
public class LogServiceFilter extends AbstractServiceFilter{

    ServiceFilter serviceFilter;

    public Object proceed(ProceedingJoinPoint pjp) throws Throwable {
        StringBuffer sb=new StringBuffer();
        sb.append("request:");
        long startTime=System.currentTimeMillis();
        Object[] args=pjp.getArgs();
        for(Object arg:args){
            sb.append(jsonUtil.toJson(arg));
        }
        Object result=null;
        try {
            result = pjp.proceed(args);
        }catch (Exception e){
            logger.info("except:",e);
        }

        if(result instanceof DataResult){
            DataResult dataResult=(DataResult)result;
            dataResult.setElapsedMilliseconds(System.currentTimeMillis()-startTime);
        }

        sb.append(jsonUtil.toJson(result));
        logger.info(sb.toString());
        return result;
    }
}
