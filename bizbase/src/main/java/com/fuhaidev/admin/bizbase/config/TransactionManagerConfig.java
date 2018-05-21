package com.fuhaidev.admin.bizbase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by xumingxun on 2018/5/19.
 */
@Configuration
public class TransactionManagerConfig {
    @Bean("oneTransactionManager")
    public PlatformTransactionManager oneTransactionManager(@Autowired @Qualifier("dataSourceOne")DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
    @Bean("twoTransactionManager")
    public PlatformTransactionManager twoTransactionManager(@Autowired @Qualifier("dataSourceTwo")DataSource ds){
        return new DataSourceTransactionManager(ds);
    }

}
