package com.gsm.controller;

import com.gsm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String,String> insertFile(MultipartFile file) throws IOException {
        String url = fileService.insertFile(file);
        Map<String,String> map = new HashMap<>(16);
        map.put("url",url);
        return map;
    }

    /**
     * 新增多个文件
     * @param files
     * @return
     */
    @PostMapping("insertFiles")
    public Map<String,String[]> insertFiles(MultipartFile[] files) throws IOException {
        String[] urls = fileService.insertFiles(files);
        Map<String,String[]> map = new HashMap<>(16);
        map.put("urls",urls);
        return map;
    }
}
