package com.ql.recruitment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.master.RecruitMDto;
import com.ql.recruitment.dto.master.UserInfoDto;
import com.ql.recruitment.entity.master.RecruitM;
import com.ql.recruitment.entity.master.UserInfo;

public interface UserInfoService {

    UserInfo getUserInfoD(UserInfoDto userInfoDto);

    int updateUserInfo(UserInfoDto userInfoDto);

    IPage<UserInfo> getUserInfo(Page<UserInfo> page, UserInfoDto userInfoDto);

    int deleteUser(UserInfoDto userInfoDto);

    int checkUser(UserInfoDto userInfoDto);

    int rejectUser(UserInfoDto userInfoDto);

    int addUser(UserInfoDto userInfoDto);
}
