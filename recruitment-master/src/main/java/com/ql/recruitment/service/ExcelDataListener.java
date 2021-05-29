package com.ql.recruitment.service;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ql.recruitment.dto.master.ExcelData;
import com.ql.recruitment.dto.master.RecruitMDto;
import com.ql.recruitment.mapper.master.RecruitDMapper;
import com.ql.recruitment.mapper.master.RecruitMMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wautumnli
 * @date: 2021-05-22 14:40
 **/
public class ExcelDataListener extends AnalysisEventListener<ExcelData> {

    private RecruitMService recruitMService;

    private Long userId;

    public ExcelDataListener(RecruitMService recruitMService,
                             Long userId) {
        this.recruitMService = recruitMService;
        this.userId = userId;
    }

    @Override
    public void invoke(ExcelData excelData, AnalysisContext analysisContext) {
        saveData(excelData, userId);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //saveData();
    }

    private void saveData(ExcelData excelData, Long userId){
        recruitMService.saveData(excelData, userId);
    }
}
