package com.taitres.controller;


import com.taitres.pojo.Result;
import com.taitres.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
    //本地上传
    @PostMapping("/localupload")
    public Result upload(String username, Integer age , MultipartFile image) throws IOException {
        log.info("上传文件,参数：{}, {}, {}",username,age,image);
        int index = image.getOriginalFilename().lastIndexOf(".");
        String suffix = image.getOriginalFilename().substring(index);
        String uuid = java.util.UUID.randomUUID().toString();
        String filename = uuid+suffix;
        log.info("文件名：{}",filename);
        image.transferTo(new File("D:\\upload\\"+filename));

        return Result.success();
    }

    //阿里云上传
    @PostMapping("/upload")
    public Result aliupload(MultipartFile image) throws IOException {
        log.info("上传文件,参数：{}",image);
        String url = aliOSSUtils.upload(image);
        log.info("文件路径：{}",url);
        return Result.success(url);
    }


}
