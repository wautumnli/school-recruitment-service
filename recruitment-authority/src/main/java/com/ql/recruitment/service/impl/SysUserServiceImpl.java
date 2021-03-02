package com.ql.recruitment.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ql.recruitment.entity.SysUser;
import com.ql.recruitment.mapper.SysUserMapper;
import com.ql.recruitment.service.SysUserService;
import com.ql.recruitment.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 16:16
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtUtil jwtUtil;

    @Override
    public SysUser getUserFromPhone(String phone) {
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        query.ge("phone", phone);
        List<SysUser> sysUserList = sysUserMapper.selectList(query);
        if (sysUserList != null && CollUtil.isNotEmpty(sysUserList)) {
            return sysUserList.get(0);
        }
        return null;
    }

    @Override
    public String login(String phone, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(phone);
        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

}
