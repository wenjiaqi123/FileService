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

    /**
     * 存储单个文件
     * @param file
     * @return
     * @throws IOException
     */
    @Override
    public String insertFile(MultipartFile file) throws IOException {
        //生成文件ID
        String fileId = FileIdUtils.getFileId();
        //根据文件ID，生成新的文件名
        String fileName = FileIdUtils.getFileName(file.getOriginalFilename(), fileId);
        //存储文件
        FileStoreUtils.storeFileByName(file, "D://aa", fileName);

        //封装信息
        FileInfo fileInfo = FileInfoUtils.packFileInfo(file);
        fileInfo.setFileId(fileId);
        fileInfo.setFileUrl("D://aa//" + fileName);
        //存储到数据库
        fileDao.insertFileInfo(fileInfo);
        return fileInfo.getFileUrl();
    }

    /**
     * 存储多个文件
     * @param files
     * @return
     */
    @Override
    public String[] insertFiles(MultipartFile[] files) throws IOException {
        //生成文件ID
        String fileId = FileIdUtils.getFileId();
        //生成文件名
        String[] fileNames = FileIdUtils.getFileNames(files);
        //存储文件
        FileStoreUtils.storeFilesByNames(files,"D://aa",fileNames);

        //生成信息
        String[] fileUrls = new String[files.length];
        for (int i = 0; i < fileUrls.length; i++) {
            fileUrls[i] = "D://aa//" + fileNames[i];
        }
        FileInfo[] fileInfos = FileInfoUtils.packFileInfos(files,fileId,fileUrls);

        fileDao.insertFileInfos(fileInfos);
        return fileUrls;
    }
}
