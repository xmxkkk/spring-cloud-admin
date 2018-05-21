package com.fuhaidev.admin.api.dto.shop;

import com.fuhaidev.admin.api.common.CommonRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * Created by xumingxun on 2018/5/18.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BuyRequest extends CommonRequest{
    @NotNull
    Integer id;
}
