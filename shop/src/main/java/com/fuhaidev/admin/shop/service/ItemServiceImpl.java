package com.fuhaidev.admin.shop.service;

import com.alibaba.fastjson.JSON;
import com.fuhaidev.admin.api.common.DataResponse;
import com.fuhaidev.admin.api.common.DataResult;
import com.fuhaidev.admin.api.dto.shop.BuyRequest;
import com.fuhaidev.admin.api.service.shop.ItemService;
import com.fuhaidev.admin.bizbase.service.AbstractServiceImpl;
import com.fuhaidev.admin.shop.third.feign.user.TokenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xumingxun on 2018/5/21.
 */
@Service
public class ItemServiceImpl extends AbstractServiceImpl implements ItemService{

    @Autowired
    TokenFeign tokenFeign;

    @Override
    public DataResult<DataResponse> buy(BuyRequest request) {
        DataResult<DataResponse> result=new DataResult<DataResponse>(new DataResponse());

        Map<String,String> data=new HashMap<String, String>();
        data.put("id","100");
        data.put("token", JSON.toJSONString(tokenFeign.getToken()));

        result.getData().setData(data);

        return result;
    }
}
