package com.fuhaidev.admin.api.common;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class DataResponse extends Response{
    Object data;
}
