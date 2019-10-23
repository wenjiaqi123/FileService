package com.gsm.utils;

import com.gsm.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 封装文件信息Util
 */
public class FileInfoUtils {

    /**
     * 装配文件信息
     * @param file
     * @return
     */
    public static FileInfo packFileInfo(MultipartFile file){
        FileInfo fileInfo = new FileInfo();
        //文件名
        fileInfo.setFileName(file.getOriginalFilename());
        //文件大小
        fileInfo.setFileSize(file.getSize());
        //创建时间
        fileInfo.setCreateTime(new Date());
        return fileInfo;
    }

    /**
     * 装配文件信息
     * @param file
     * @param fileId
     * @param fileUrl
     * @return
     */
    public static FileInfo packFileInfo(MultipartFile file,String fileId,String fileUrl){
        FileInfo fileInfo = FileInfoUtils.packFileInfo(file);
        //文件 FileId
        fileInfo.setFileId(fileId);
        //文件 Url
        fileInfo.setFileUrl(fileUrl);
        return fileInfo;
    }
}
