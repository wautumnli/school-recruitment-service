package com.ql.recruitment.web.master;

import com.alibaba.excel.EasyExcel;
import com.ql.recruitment.dto.master.ExcelData;
import com.ql.recruitment.result.R;
import com.ql.recruitment.service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wautumnli
 * @date: 2021-05-22 19:02
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private RecruitMService recruitMService;
    @Resource
    private InterviewService interviewService;
    @Resource
    private FileMService fileMService;

    @PostMapping("/home")
    public R home() {
        Map<String, Object> result = new HashMap<>();
        result.put("userCount", sysUserService.countUser());
        result.put("positionCount", recruitMService.countPosition());
        result.put("interviewCount", interviewService.countInterview());
        result.put("fileCount", fileMService.countFile());
        result.put("typeCount", sysUserService.countUserType());
        return R.ok().data(result);
    }
}
