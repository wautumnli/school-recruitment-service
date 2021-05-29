package com.ql.recruitment.mapper.interview;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.interview.InterviewDto;
import com.ql.recruitment.entity.interview.Interview;

/**
 * @author: wautumnli
 * @date: 2021-05-18 17:26
 **/
public interface InterviewMapper extends BaseMapper<Interview> {
    IPage<Interview> getInterview(Page<Interview> page, InterviewDto interviewDto);
}
