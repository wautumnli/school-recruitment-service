package com.ql.recruitment.web.file;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.file.FileMDto;
import com.ql.recruitment.entity.file.FileM;
import com.ql.recruitment.service.minio.MinioService;
import com.ql.recruitment.result.R;
import com.ql.recruitment.service.FileMService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wautumnli
 * @date: 2021-05-18 18:36
 **/
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileMService fileMService;

    @PostMapping("/home")
    public R home(@RequestBody FileMDto fileMDto){
        Map<String, Object> result = new HashMap<>();
        Page<FileM> page = new Page<>(fileMDto.getPageNum(),fileMDto.getPageSize());
        result.put("file", fileMService.getFile(page, fileMDto));
        return R.ok().data(result);
    }

    @PostMapping("/upload")
    public R upload( @RequestParam("file") MultipartFile file, @RequestParam("userId") Long userId) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("file", fileMService.upload(file, userId));
        return R.ok().data(result);
    }

    @PostMapping("/delete")
    public R delete(@RequestBody FileMDto fileMDto) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("delete", fileMService.delete(fileMDto));
        return R.ok().data(result);
    }
}
