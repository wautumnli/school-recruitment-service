package com.ql.recruitment.dto.authority;

import lombok.Data;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/2 14:00
 */
@Data
public class SysUserDto {

    /**
     * 用户唯一id
     */
    private Long id;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户昵称
     */
    private String nickName;
}
