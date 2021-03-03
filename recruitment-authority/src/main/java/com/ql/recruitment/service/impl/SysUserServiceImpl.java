package com.ql.recruitment.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ql.recruitment.entity.authority.SysUser;
import com.ql.recruitment.exception.AuthorityException;
import com.ql.recruitment.mapper.authority.SysUserMapper;
import com.ql.recruitment.service.SysUserService;
import com.ql.recruitment.util.JwtUtil;
import com.ql.recruitment.dto.authority.SysUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 16:16
 */
@Slf4j
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
        query.eq("phone", phone);
        List<SysUser> sysUserList = sysUserMapper.selectList(query);
        if (sysUserList != null && CollUtil.isNotEmpty(sysUserList)) {
            return sysUserList.get(0);
        }
        return null;
    }

    @Override
    public String login(SysUserDto sysUserDto) {
        // 获取账号信息
        UserDetails userDetails = userDetailsService.loadUserByUsername(sysUserDto.getPhone());
        // 比较密码是否相同
        String myPassword = sysUserDto.getPassword();
        String dbPassword = userDetails.getPassword();
        if (Objects.isNull(myPassword) || Objects.isNull(dbPassword) || !Objects.equals(myPassword, dbPassword)) {
            throw new AuthorityException("密码不正确");
        }
        return jwtUtil.generateToken(userDetails);
    }
}
