package com.ql.recruitment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.interview.InterviewDto;
import com.ql.recruitment.entity.interview.Interview;

/**
 * @author: wautumnli
 * @date: 2021-05-18 17:22
 **/
public interface InterviewService {

    public IPage<Interview> getInterview(Page<Interview> page, InterviewDto interviewDto);

    int addInterview(InterviewDto interviewDto);

    int deleteInterview(InterviewDto interviewDto);

    void addHot(InterviewDto interviewDto);

    int countInterview();
}
