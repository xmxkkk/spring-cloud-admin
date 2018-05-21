package com.fuhaidev.admin.shop.controller;

import com.fuhaidev.admin.api.common.DataResponse;
import com.fuhaidev.admin.api.common.DataResult;
import com.fuhaidev.admin.api.dto.shop.BuyRequest;
import com.fuhaidev.admin.api.service.shop.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by xumingxun on 2018/5/21.
 */
@RestController
@RequestMapping("item")
@RefreshScope
@ResponseBody
public class ItemController {

    @Autowired
    ItemService service;

    @RequestMapping("buy")
    public DataResult<DataResponse> buy(@RequestBody BuyRequest request) throws Exception{
        return service.buy(request);
    }
}
