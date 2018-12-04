package com.qiuxiujie.demo.service;

import com.qiuxiujie.demo.util.ResultObjStr;
import org.springframework.web.multipart.MultipartFile;

public interface DataImportService {
    ResultObjStr importExcel(MultipartFile file, Integer myId);
}
