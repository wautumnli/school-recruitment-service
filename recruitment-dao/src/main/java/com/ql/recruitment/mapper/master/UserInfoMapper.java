package com.ql.recruitment.mapper.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.master.RecruitMDto;
import com.ql.recruitment.dto.master.UserInfoDto;
import com.ql.recruitment.entity.master.RecruitM;
import com.ql.recruitment.entity.master.UserInfo;

/**
 * @author: wautumnli
 * @date: 2021-05-19 05:15
 **/
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    UserInfo getUserInfoD(UserInfoDto userInfoDto);

    IPage<UserInfo> getUserInfo(Page<UserInfo> page, UserInfoDto userInfoDto);
}
