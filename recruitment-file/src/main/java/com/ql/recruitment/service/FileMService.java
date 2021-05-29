package com.ql.recruitment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.file.FileMDto;
import com.ql.recruitment.entity.file.FileM;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: wautumnli
 * @date: 2021-05-18 18:32
 **/
public interface FileMService {

    public IPage<FileM> getFile(Page<FileM> page, FileMDto fileMDto);

    int upload(MultipartFile file, Long userId) throws Exception;

    int delete(FileMDto fileMDto) throws Exception;

    int countFile();
}
