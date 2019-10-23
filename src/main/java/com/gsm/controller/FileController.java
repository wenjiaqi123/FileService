package com.gsm.controller;

import com.gsm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * 新增一个文件
     * @param file
     * @return
     */
    @PostMapping("insertFile")
    public String insertFile(MultipartFile file) throws IOException {
        String url = fileService.insertFile(file);
        return url;
    }

    /**
     * 新增多个文件
     * @param files
     * @return
     */
    @PostMapping("insertFiles")
    public String insertFiles(MultipartFile[] files){
        return "ss";
    }
}
