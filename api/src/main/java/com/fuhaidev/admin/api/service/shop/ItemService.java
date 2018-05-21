package com.fuhaidev.admin.api.service.shop;

import com.fuhaidev.admin.api.common.DataResponse;
import com.fuhaidev.admin.api.common.DataResult;
import com.fuhaidev.admin.api.dto.shop.BuyRequest;

import java.util.Map;

/**
 * Created by xumingxun on 2018/5/18.
 */
public interface ItemService {
    DataResult<DataResponse> buy(BuyRequest request);
}
