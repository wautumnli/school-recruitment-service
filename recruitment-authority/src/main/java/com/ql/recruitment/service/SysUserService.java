package com.ql.recruitment.service;

import com.ql.recruitment.entity.authority.SysUser;
import com.ql.recruitment.dto.authority.SysUserDto;

import java.util.List;
import java.util.Map;

/**
 * 用户主档接口
 * Author： wanqiuli
 * DateTime: 2021/3/1 16:14
 */
public interface SysUserService {

    /**
     * 获取
     * @param username
     * @return
     */
    public SysUser getUserFromUsername(String username);

    public Map<String, Object> login(SysUserDto sysUserDto);

    int applyUser(SysUserDto sysUserDto);

    int countUser();

    List<Integer> countUserType();
}
