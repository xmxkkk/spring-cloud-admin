package com.fuhaidev.admin.dao.common;

/**
 * Created by xumingxun on 2018/5/18.
 */
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}