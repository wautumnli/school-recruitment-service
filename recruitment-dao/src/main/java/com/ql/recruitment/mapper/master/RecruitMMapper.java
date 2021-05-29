package com.ql.recruitment.mapper.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.master.RecruitMDto;
import com.ql.recruitment.entity.master.RecruitM;

import java.util.List;

public interface RecruitMMapper extends BaseMapper<RecruitM> {

    List<RecruitM> getRecruitM(RecruitMDto recruitMDto);

    IPage<RecruitM> getRecruit(Page<RecruitM> page, RecruitMDto recruitMDto);

    RecruitM getDetail(RecruitMDto recruitMDto);
}
