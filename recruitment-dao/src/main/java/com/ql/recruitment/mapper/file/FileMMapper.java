package com.ql.recruitment.mapper.file;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.file.FileMDto;
import com.ql.recruitment.entity.file.FileM;

/**
 * @author: wautumnli
 * @date: 2021-05-18 18:24
 **/
public interface FileMMapper extends BaseMapper<FileM> {
    IPage<FileM> getFile(Page<FileM> page, FileMDto fileMDto);
}
