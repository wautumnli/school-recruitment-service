package com.ql.recruitment.web.master;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.master.ExcelData;
import com.ql.recruitment.dto.master.RecruitDDto;
import com.ql.recruitment.dto.master.RecruitMDto;
import com.ql.recruitment.entity.master.CompanyM;
import com.ql.recruitment.entity.master.RecruitM;
import com.ql.recruitment.result.R;
import com.ql.recruitment.service.CompanyMService;
import com.ql.recruitment.service.ExcelDataListener;
import com.ql.recruitment.service.RecruitMService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wautumnli
 * @date: 2021-05-13 16:57
 **/
@RestController
@RequestMapping("/recruitm")
public class RecruitController {

    @Resource
    private RecruitMService recruitMService;
    @Resource
    private CompanyMService companyMService;

    @PostMapping("/home")
    public R home(){
        Map<String, Object> result = new HashMap<>();
        List<RecruitM> industry = recruitMService.getIndustry();
        RecruitMDto condition = new RecruitMDto()
                .setRecruitType(1)
                .setIndustry(industry.get(0).getIndustry());
        result.put("industry", industry);
        result.put("company", companyMService.getCompanyM());
        result.put("school", recruitMService.getRecruitM(condition));
        condition.setRecruitType(0);
        result.put("practice", recruitMService.getRecruitM(condition));
        return R.ok().data(result);
    }

    @PostMapping("/school")
    public R school(@RequestBody RecruitMDto recruitMDto){
        Map<String, Object> result = new HashMap<>();
        Page<RecruitM> page = new Page<RecruitM>(recruitMDto.getPageNum(),recruitMDto.getPageSize());
        result.put("school", recruitMService.getRecruit(page, recruitMDto));
        return R.ok().data(result);
    }

    @PostMapping("/industry")
    public R industry() {
        Map<String, Object> result = new HashMap<>();
        result.put("data",recruitMService.getIndustry());
        return R.ok().data(result);
    }

    @PostMapping("/getCompany")
    public R getCompany(){
        Map<String, Object> result = new HashMap<>();
        result.put("company",companyMService.getAllCompanyM());
        return R.ok().data(result);
    }

    @PostMapping("/add")
    public R add(@RequestBody RecruitMDto recruitMDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("add",recruitMService.addRecruit(recruitMDto));
        return R.ok().data(result);
    }

    @PostMapping("/delete")
    public R delete(@RequestBody RecruitMDto recruitMDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("delete",recruitMService.deleteRecruit(recruitMDto));
        return R.ok().data(result);
    }

    @PostMapping("/detail")
    public R detail(@RequestBody RecruitMDto recruitMDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("detail",recruitMService.checkRecruit(recruitMDto));
        return R.ok().data(result);
    }

    @PostMapping("/batch")
    public R batch(@RequestParam("file") MultipartFile file, @RequestParam("userId") Long userId) throws Exception {
        EasyExcel.read(file.getInputStream(), ExcelData.class, new ExcelDataListener(recruitMService, userId)).sheet().doRead();
        Map<String, Object> result = new HashMap<>();
        result.put("batch", "success");
        return R.ok().data(result);
    }

}
