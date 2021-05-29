package com.ql.recruitment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.master.ExcelData;
import com.ql.recruitment.dto.master.RecruitDDto;
import com.ql.recruitment.dto.master.RecruitMDto;
import com.ql.recruitment.entity.master.RecruitM;

import java.util.List;

/**
 * @author: wautumnli
 * @date: 2021-05-13 16:42
 **/
public interface RecruitMService {

    /**
     * 获取部分招聘行业 首页
     * @return
     */
    public List<RecruitM> getIndustry();

    /**
     * 获取招聘信息 首页
     * @param recruitMDto
     * @return
     */
    public List<RecruitM> getRecruitM(RecruitMDto recruitMDto);

    /**
     * 获取招聘信息 招聘页
     * @param recruitMDto
     * @return
     */
    public IPage<RecruitM> getRecruit(Page<RecruitM> page, RecruitMDto recruitMDto);

    int addRecruit(RecruitMDto recruitMDto);

    int deleteRecruit(RecruitMDto recruitMDto);

    RecruitM checkRecruit(RecruitMDto recruitMDto);

    void saveData(ExcelData excelData,Long userId);

    int countPosition();
}
