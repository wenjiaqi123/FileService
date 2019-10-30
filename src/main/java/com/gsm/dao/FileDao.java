package com.gsm.dao;

import com.gsm.model.FileInfo;

public interface FileDao {
    void insertFileInfo(FileInfo fileInfo);

    FileInfo selectFileInfo(String fileId);


    void insertFileInfos(FileInfo[] fileInfos);

    FileInfo[] selectFileInfos(String fileId);
}
