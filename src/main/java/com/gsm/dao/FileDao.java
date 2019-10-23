package com.gsm.dao;

import com.gsm.model.FileInfo;

public interface FileDao {
    void insertFileInfo(FileInfo fileInfo);

    void insertFileInfos(FileInfo[] fileInfos);
}
