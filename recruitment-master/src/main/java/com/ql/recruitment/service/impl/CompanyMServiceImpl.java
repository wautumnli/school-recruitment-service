package com.ql.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ql.recruitment.entity.master.CompanyM;
import com.ql.recruitment.mapper.master.CompanyMMapper;
import com.ql.recruitment.service.CompanyMService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wautumnli
 * @date: 2021-05-13 17:26
 **/
@Service
public class CompanyMServiceImpl implements CompanyMService {

    @Resource
    private CompanyMMapper companyMMapper;

    @Override
    public List<CompanyM> getCompanyM() {
        LambdaQueryWrapper<CompanyM> select = new LambdaQueryWrapper<CompanyM>()
                .last("limit 8");
        return companyMMapper.selectList(select);
    }

    @Override
    public List<CompanyM> getAllCompanyM() {
        return companyMMapper.selectList(null);
    }
}
