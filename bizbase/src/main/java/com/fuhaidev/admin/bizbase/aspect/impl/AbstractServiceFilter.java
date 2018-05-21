package com.fuhaidev.admin.bizbase.aspect.impl;

import com.fuhaidev.admin.bizbase.aspect.ServiceFilter;
import com.fuhaidev.admin.bizbase.utils.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xumingxun on 2018/5/14.
 */
public abstract class AbstractServiceFilter implements ServiceFilter {
    protected Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    protected JsonUtil jsonUtil;
}
