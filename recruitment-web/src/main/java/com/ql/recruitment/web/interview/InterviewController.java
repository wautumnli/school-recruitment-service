package com.ql.recruitment.web.interview;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.interview.InterviewDto;
import com.ql.recruitment.entity.interview.Interview;
import com.ql.recruitment.result.R;
import com.ql.recruitment.service.InterviewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wautumnli
 * @date: 2021-05-18 17:52
 **/
@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Resource
    private InterviewService interviewService;

    @PostMapping("/home")
    public R home(@RequestBody InterviewDto interviewDto) {
        Map<String, Object> result = new HashMap<>();
        Page<Interview> page = new Page<>(interviewDto.getPageNum(),interviewDto.getPageSize());
        result.put("interview", interviewService.getInterview(page, interviewDto));
        return R.ok().data(result);
    }

    @PostMapping("/add")
    public R add(@RequestBody InterviewDto interviewDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("add", interviewService.addInterview(interviewDto));
        return R.ok().data(result);
    }

    @PostMapping("/delete")
    public R delete(@RequestBody InterviewDto interviewDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("add", interviewService.deleteInterview(interviewDto));
        return R.ok().data(result);
    }

    @PostMapping("/addhot")
    public void addHot(@RequestBody InterviewDto interviewDto) {
        interviewService.addHot(interviewDto);
    }
}
