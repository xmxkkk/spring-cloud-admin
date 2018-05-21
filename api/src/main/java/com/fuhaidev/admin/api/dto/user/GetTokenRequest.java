package com.fuhaidev.admin.api.dto.user;

import com.fuhaidev.admin.api.common.CommonRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by xumingxun on 2018/5/18.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GetTokenRequest extends CommonRequest{
    @NotNull
    @NotEmpty
    String uid;

}
