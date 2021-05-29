package com.ql.recruitment.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.authority.SysUserDto;
import com.ql.recruitment.dto.master.UserInfoDto;
import com.ql.recruitment.entity.authority.SysUser;
import com.ql.recruitment.entity.master.UserInfo;
import com.ql.recruitment.mapper.authority.SysUserMapper;
import com.ql.recruitment.mapper.master.UserInfoMapper;
import com.ql.recruitment.service.UserInfoService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2021-05-19 05:24
**/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo getUserInfoD(UserInfoDto userInfoDto) {
        return userInfoMapper.getUserInfoD(userInfoDto);
    }

    @Override
    public int updateUserInfo(UserInfoDto userInfoDto) {
        UserInfo userInfo = new UserInfo()
                .setId(userInfoDto.getId())
                .setUserId(userInfoDto.getUserId())
                .setBirthday(userInfoDto.getBirthday())
                .setCollege(userInfoDto.getCollege())
                .setGrade(userInfoDto.getGrade())
                .setClassName(userInfoDto.getClassName())
                .setSex(userInfoDto.getSex());
        int uRes = userInfoMapper.updateById(userInfo);

        SysUser sysUser = new SysUser()
                .setId(userInfoDto.getUserId())
                .setNickName(userInfoDto.getUserNickName());
        if (userInfoDto.getUserPassword() != null) {
            sysUser.setPassword(passwordEncoder.encode(userInfoDto.getUserPassword()));
        }
        int sRes = sysUserMapper.updateById(sysUser);

        return uRes != 0 && uRes ==  sRes ? 1 : 0;
    }

    @Override
    public IPage<UserInfo> getUserInfo(Page<UserInfo> page, UserInfoDto userInfoDto) {
        return userInfoMapper.getUserInfo(page, userInfoDto);
    }

    @Override
    public int deleteUser(UserInfoDto userInfoDto) {
        int uRes = userInfoMapper.deleteById(userInfoDto.getId());
        int sRes = sysUserMapper.deleteById(userInfoDto.getUserId());
        return uRes == 1 && uRes == sRes ? 1 : 0;
    }

    @Override
    public int checkUser(UserInfoDto userInfoDto) {
        SysUser sysUser = new SysUser()
                .setId(userInfoDto.getUserId())
                .setUserType(userInfoDto.getUserType());
        return sysUserMapper.updateById(sysUser);
    }

    @Override
    public int rejectUser(UserInfoDto userInfoDto) {
        SysUser sysUser = new SysUser()
                .setId(userInfoDto.getUserId())
                .setUserType(0);
        return sysUserMapper.updateById(sysUser);
    }

    @Override
    @Transactional
    public int addUser(UserInfoDto userInfoDto) {
        int userType = userInfoDto.getUserType() == 1? -1 : 0;
        SysUser sysUser = new SysUser()
                .setUsername(userInfoDto.getUsername())
                .setPassword(passwordEncoder.encode(userInfoDto.getUserPassword()))
                .setNickName(userInfoDto.getUserNickName())
                .setUserType(userType);
        int sRes = sysUserMapper.insert(sysUser);

        UserInfo userInfo = new UserInfo()
                .setUserId(sysUser.getId())
                .setCollege("")
                .setClassName("")
                .setGrade("")
                .setSex(1)
                .setBirthday(new Date());
        int uRes = userInfoMapper.insert(userInfo);
        return sRes == 1 && sRes == uRes ? 1 : 0;
    }
}
