package com.ql.recruitment.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.file.FileMDto;
import com.ql.recruitment.entity.file.FileM;
import com.ql.recruitment.mapper.file.FileMMapper;
import com.ql.recruitment.service.FileMService;
import com.ql.recruitment.service.minio.MinioService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2021-05-18 18:32
 **/
@Service
public class FileMServiceImpl implements FileMService {

    @Resource
    private FileMMapper fileMMapper;
    @Resource
    private MinioService minioService;

    @Override
    public IPage<FileM> getFile(Page<FileM> page, FileMDto fileMDto) {
        return fileMMapper.getFile(page, fileMDto);
    }

    @Override
    public int upload(MultipartFile file, Long userId) throws Exception {
        String url = minioService.upload(file);
        FileM fileM = new FileM()
                .setFileName(file.getOriginalFilename())
                .setFileType(file.getContentType())
                .setFileSize((file.getSize()*1.0/1000) + "")
                .setFileUrl(url)
                .setPublishUser(userId)
                .setCreateTime(new Date());
        return fileMMapper.insert(fileM);
    }

    @Override
    public int delete(FileMDto fileMDto) throws Exception{
        minioService.deleteFile(fileMDto.getFileName());
        return fileMMapper.deleteById(fileMDto.getId());
    }

    @Override
    public int countFile() {
        return fileMMapper.selectCount(null);
    }

}
