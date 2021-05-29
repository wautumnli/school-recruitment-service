package com.ql.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.master.ExcelData;
import com.ql.recruitment.dto.master.RecruitMDto;
import com.ql.recruitment.entity.master.RecruitD;
import com.ql.recruitment.entity.master.RecruitM;
import com.ql.recruitment.mapper.master.RecruitDMapper;
import com.ql.recruitment.mapper.master.RecruitMMapper;
import com.ql.recruitment.service.RecruitMService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wautumnli
 * @date: 2021-05-13 16:48
 **/
@Service
public class RecruitMServiceImpl implements RecruitMService {

    @Resource
    private RecruitMMapper recruitMMapper;

    @Resource
    private RecruitDMapper recruitDMapper;

    @Override
    public List<RecruitM> getIndustry() {
        LambdaQueryWrapper<RecruitM> select = new LambdaQueryWrapper<RecruitM>()
                .groupBy(RecruitM::getIndustry)
                .select(RecruitM::getIndustry)
                .last("limit 10");
        return recruitMMapper.selectList(select);
    }

    @Override
    public List<RecruitM> getRecruitM(RecruitMDto recruitMDto) {
        return recruitMMapper.getRecruitM(recruitMDto);
    }

    @Override
    public IPage<RecruitM> getRecruit(Page<RecruitM> page, RecruitMDto recruitMDto) {
        return recruitMMapper.getRecruit(page, recruitMDto);
    }

    @Override
    @Transactional
    public int addRecruit(RecruitMDto recruitMDto) {
        RecruitM recruitM = new RecruitM()
                .setPosition(recruitMDto.getPosition())
                .setCompanyId(recruitMDto.getCompanyId())
                .setWages(recruitMDto.getWages())
                .setWorkPlace(recruitMDto.getWorkPlace())
                .setEducation(recruitMDto.getEducation())
                .setRecruitType(recruitMDto.getRecruitType())
                .setIndustry(recruitMDto.getIndustry())
                .setUserId(recruitMDto.getUserId())
                .setCreateTime(new Date());
        int mRes = recruitMMapper.insert(recruitM);
        RecruitD recruitD = new RecruitD()
                .setContent(recruitMDto.getContent())
                .setEmail(recruitMDto.getEmail())
                .setPId(recruitM.getId());
        int dRes = recruitDMapper.insert(recruitD);

        return mRes != 0 && mRes == dRes ? 1 : 0;
    }

    @Override
    @Transactional
    public int deleteRecruit(RecruitMDto recruitMDto) {
        int mRes = recruitMMapper.deleteById(recruitMDto.getId());
        Map<String, Object> deleteMap = new HashMap<>();
        deleteMap.put("p_id", recruitMDto.getId());
        int dRes = recruitDMapper.deleteByMap(deleteMap);
        return mRes != 0 && mRes == dRes ? 1 : 0;
    }

    @Override
    public RecruitM checkRecruit(RecruitMDto recruitMDto) {
        return recruitMMapper.getDetail(recruitMDto);
    }

    @Override
    public void saveData(ExcelData excelData, Long userId) {
        RecruitM recruitM = new RecruitM()
                .setPosition(excelData.getPosition())
                .setCompanyId(excelData.getCompanyId())
                .setWages(excelData.getWages())
                .setWorkPlace(excelData.getWorkPlace())
                .setEducation(excelData.getEducation())
                .setRecruitType(excelData.getRecruitType())
                .setIndustry(excelData.getIndustry())
                .setUserId(userId)
                .setCreateTime(new Date());
        recruitMMapper.insert(recruitM);
        RecruitD recruitD = new RecruitD()
                .setContent(excelData.getContent())
                .setEmail(excelData.getEmail())
                .setPId(recruitM.getId());
        recruitDMapper.insert(recruitD);
    }

    @Override
    public int countPosition() {
        return recruitMMapper.selectCount(null);
    }
}
