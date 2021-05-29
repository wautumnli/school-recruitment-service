package com.ql.recruitment.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.interview.InterviewDto;
import com.ql.recruitment.entity.interview.Interview;
import com.ql.recruitment.mapper.interview.InterviewMapper;
import com.ql.recruitment.service.InterviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2021-05-18 17:22
 **/
@Service
public class InterviewServiceImpl implements InterviewService {

    @Resource
    private InterviewMapper interviewMapper;


    @Override
    public IPage<Interview> getInterview(Page<Interview> page, InterviewDto interviewDto) {
        return interviewMapper.getInterview(page, interviewDto);
    }

    @Override
    @Transactional
    public int addInterview(InterviewDto interviewDto) {
        Interview interview = new Interview()
                .setTitle(interviewDto.getTitle())
                .setContent(interviewDto.getContent())
                .setCompanyName(interviewDto.getCompanyName())
                .setPosition(interviewDto.getPosition())
                .setPublishUser(interviewDto.getUserId())
                .setHot(0)
                .setCreateTime(new Date());
        return interviewMapper.insert(interview);
    }

    @Override
    @Transactional
    public int deleteInterview(InterviewDto interviewDto) {
        return interviewMapper.deleteById(interviewDto.getId());
    }

    @Override
    public void addHot(InterviewDto interviewDto) {
        Interview interview = new Interview()
                .setId(interviewDto.getId())
                .setHot(interviewDto.getHot());

        interviewMapper.updateById(interview);
    }

    @Override
    public int countInterview() {
        return interviewMapper.selectCount(null);
    }
}
