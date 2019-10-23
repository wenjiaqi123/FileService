package com.gsm.service.impl;

import com.gsm.dao.FileDao;
import com.gsm.model.FileInfo;
import com.gsm.service.FileService;
import com.gsm.utils.FileIdUtils;
import com.gsm.utils.FileInfoUtils;
import com.gsm.utils.FileStoreUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public String insertFile(MultipartFile file) throws IOException {
        //文件ID
        String fileId = FileIdUtils.getFileId();
        //根据文件ID，生成新的文件名
        String fileName = FileIdUtils.getFileName(file.getOriginalFilename(), fileId);
        //存储文件
        FileStoreUtils.storeFileByName(file, "D://aa", fileName);
        int i = 1/0;
        //封装信息
        FileInfo fileInfo = FileInfoUtils.packFileInfo(file);
        fileInfo.setFileId(fileId);
        fileInfo.setFileUrl("aaa");
        //存储到数据库
        fileDao.insertFileInfo(fileInfo);
        return fileInfo.getFileUrl();
    }
}
