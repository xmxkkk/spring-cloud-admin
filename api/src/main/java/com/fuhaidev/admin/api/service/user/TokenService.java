package com.fuhaidev.admin.api.service.user;

import com.fuhaidev.admin.api.common.DataResponse;
import com.fuhaidev.admin.api.common.DataResult;
import com.fuhaidev.admin.api.dto.user.GetTokenRequest;

import java.util.Map;

/**
 * Created by xumingxun on 2018/5/18.
 */
public interface TokenService {
    DataResult<DataResponse> getToken(GetTokenRequest request);
    void showToken();
}
