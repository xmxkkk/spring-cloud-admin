package com.fuhaidev.admin.user.controller;

import com.fuhaidev.admin.api.common.DataResponse;
import com.fuhaidev.admin.api.common.DataResult;
import com.fuhaidev.admin.api.dto.user.GetTokenRequest;
import com.fuhaidev.admin.api.service.user.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xumingxun on 2018/5/18.
 */
@RestController
@RequestMapping("token")
@RefreshScope
@ResponseBody
public class TokenController {

    @Autowired
    TokenService service;

    @RequestMapping("getToken")
    public DataResult<DataResponse> getToken(@RequestBody GetTokenRequest request) throws Exception{
        return service.getToken(request);
    }
    @RequestMapping("showToken")
    public void showToken() throws Exception{
        service.showToken();
    }
}
