package com.gsm.service;

import com.gsm.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String insertFile(MultipartFile file) throws IOException;

    FileInfo insertFileGetAllInfo(MultipartFile file) throws IOException;


    String[] insertFiles(MultipartFile[] files) throws IOException;

    FileInfo[] insertFilesGetAllInfos(MultipartFile[] files) throws IOException;
}
