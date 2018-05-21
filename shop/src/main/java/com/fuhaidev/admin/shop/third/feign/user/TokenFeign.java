package com.fuhaidev.admin.shop.third.feign.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by xumingxun on 2018/5/21.
 */
@FeignClient(name="user")
@RequestMapping("/token")
public interface TokenFeign {
    @RequestMapping("getToken")
    public Map<String,String> getToken();
}
