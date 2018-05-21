package com.fuhaidev.admin.bizbase.config;

import com.fuhaidev.admin.bizbase.utils.MapperConfigUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;

/**
 * Created by xumingxun on 2018/5/19.
 */
@Configuration
public class MapperConfig {
    @Primary
    @Bean("oneSqlSessionFactory")
    public SqlSessionFactory oneSqlSessionFactory(@Autowired @Qualifier("dataSourceOne")DataSource ds)throws Exception{
        return MapperConfigUtil.getSqlSessionFactory(ds,"classpath*:mybatis/test1/*.xml");
    }
    @Bean("twoSqlSessionFactory")
    public SqlSessionFactory twoSqlSessionFactory(@Autowired @Qualifier("dataSourceTwo")DataSource ds)throws Exception{
        return MapperConfigUtil.getSqlSessionFactory(ds,"classpath*:mybatis/test2/*.xml");
    }
    @Bean(name="oneMapperScannerConfigurer")
    public MapperScannerConfigurer oneMapperScannerConfigurer(){
        return MapperConfigUtil.getMapperScannerConfigurer("oneSqlSessionFactory","com.fuhaidev.admin.dao.mapper.test1");
    }
    @Bean(name="twoMapperScannerConfigurer")
    public MapperScannerConfigurer twoMapperScannerConfigurer(){
        return MapperConfigUtil.getMapperScannerConfigurer("twoSqlSessionFactory","com.fuhaidev.admin.dao.mapper.test2");
    }
}
