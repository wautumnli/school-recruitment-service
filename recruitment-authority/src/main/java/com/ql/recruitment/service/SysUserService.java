package com.ql.recruitment.service;

import com.ql.recruitment.entity.authority.SysUser;
import com.ql.recruitment.dto.authority.SysUserDto;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 16:14
 */
public interface SysUserService {

    public SysUser getUserFromPhone(String phone);

    public String login(SysUserDto sysUserDto);
}
