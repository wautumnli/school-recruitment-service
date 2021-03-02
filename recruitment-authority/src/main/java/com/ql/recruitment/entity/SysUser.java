package com.ql.recruitment.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 15:44
 */
@Data
@Builder
public class SysUser {

    private Long id;
    private String phone;
    private String password;
    private String nickName;
}
