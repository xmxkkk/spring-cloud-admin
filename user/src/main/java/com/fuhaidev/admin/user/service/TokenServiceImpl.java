package com.fuhaidev.admin.user.service;

import com.alibaba.fastjson.JSON;
import com.fuhaidev.admin.api.common.DataResponse;
import com.fuhaidev.admin.api.common.DataResult;
import com.fuhaidev.admin.api.dto.user.GetTokenRequest;
import com.fuhaidev.admin.api.service.user.TokenService;
import com.fuhaidev.admin.bizbase.service.AbstractServiceImpl;
import com.fuhaidev.admin.dao.entity.test1.UserEntity;
import com.fuhaidev.admin.dao.entity.test2.ItemEntity;
import com.fuhaidev.admin.dao.mapper.test1.UserEntityMapper;
import com.fuhaidev.admin.dao.mapper.test2.ItemEntityMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xumingxun on 2018/5/18.
 */
@Service
public class TokenServiceImpl extends AbstractServiceImpl implements TokenService{

    @Value("${shop_url}")
    String shopUrl;

    @Autowired
    UserEntityMapper userEntityMapper;

    @Autowired
    ItemEntityMapper itemEntityMapper;

    @Override
    @Transactional(rollbackFor = Throwable.class,transactionManager = "oneTransactionManager")
    public DataResult<DataResponse> getToken(GetTokenRequest request){
        DataResult<DataResponse> result=new DataResult<DataResponse>(new DataResponse());
        Map<String,String> data=new HashMap<String, String>();
        data.put("token","12456");
        data.put("shopUrl",shopUrl);

        PageHelper.startPage(0,2);
        List<UserEntity> users=userEntityMapper.selectAll();
        data.put("users",JSON.toJSONString(users));

        UserEntity user=userEntityMapper.selectByPrimaryKey(1);
        data.put("user", JSON.toJSONString(user));

        ItemEntity item=itemEntityMapper.selectByPrimaryKey(1);
        data.put("item",JSON.toJSONString(item));

        UserEntity upd=new UserEntity();
        upd.setId(1);
        upd.setAge(111);
        userEntityMapper.updateByPrimaryKeySelective(upd);

        result.getData().setData(data);

//        int x=1/0;

        return result;
    }

    @Override
    public void showToken() {

    }
}
