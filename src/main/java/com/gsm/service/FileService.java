package com.gsm.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String insertFile(MultipartFile file) throws IOException;

    String[] insertFiles(MultipartFile[] files) throws IOException;
}
