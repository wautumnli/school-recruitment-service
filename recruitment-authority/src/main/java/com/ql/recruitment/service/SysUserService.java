package com.ql.recruitment.service;

import com.ql.recruitment.entity.SysUser;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 16:14
 */
public interface SysUserService {

    public SysUser getUserFromPhone(String phone);

    public String login(String phone, String password);
}
