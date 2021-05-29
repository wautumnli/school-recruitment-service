package com.ql.recruitment.service.impl;

import cn.hutool.core.collection.CollUtil;
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
import java.util.*;

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
    public SysUser getUserFromUsername(String username) {
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        query.eq("username", username);
        List<SysUser> sysUserList = sysUserMapper.selectList(query);
        if (sysUserList != null && CollUtil.isNotEmpty(sysUserList)) {
            return sysUserList.get(0);
        }
        return null;
    }

    @Override
    public Map<String, Object> login(SysUserDto sysUserDto) {
        // 获取账号信息
        UserDetails userDetails = userDetailsService.loadUserByUsername(sysUserDto.getUsername());
        // 比较密码是否相同
        String myPassword = sysUserDto.getPassword();
        String dbPassword = userDetails.getPassword();
        if (Objects.isNull(myPassword) || Objects.isNull(dbPassword) || !passwordEncoder.matches(myPassword, dbPassword)) {
            throw new AuthorityException("密码不正确");
        }

        Map<String, Object> result = new HashMap<>();
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("username", userDetails.getUsername());
        SysUser sysUser = sysUserMapper.selectByMap(condition).get(0);
        if (sysUser.getUserType() == -1) {
            throw new AuthorityException("账号还未审核");
        }
        if (sysUserDto.getLoginType() == 0 && sysUser.getUserType() != 3) {
            throw new AuthorityException("不是管理员账号");
        }
        if (sysUserDto.getLoginType() == 1 && sysUser.getUserType() == 3) {
            throw new AuthorityException("管理员不能登录客户端");
        }
        result.put("token", jwtUtil.generateToken(userDetails));
        result.put("username", userDetails.getUsername());
        result.put("userType", sysUser.getUserType());
        result.put("userId", sysUser.getId());
        return result;
    }

    @Override
    public int applyUser(SysUserDto sysUserDto) {
        SysUser sysUser = new SysUser()
                .setId(sysUserDto.getId())
                .setUserType(-1);

        return sysUserMapper.updateById(sysUser);
    }

    @Override
    public int countUser() {
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        return sysUserMapper.selectCount(query);
    }

    @Override
    public List<Integer> countUserType() {
        List<Integer> counts = new ArrayList<>();
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        query.eq("user_type", 1);
        int res1 = sysUserMapper.selectCount(query);
        QueryWrapper<SysUser> query2 = new QueryWrapper<>();
        query2.eq("user_type", 0);
        int res2 = sysUserMapper.selectCount(query2);
        counts.add(res1);
        counts.add(res2);
        return counts;
    }
}
