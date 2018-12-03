package com.qiuxiujie.demo.service;

import com.qiuxiujie.demo.util.ResultObjStr;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;

public interface ISiteInfoService {
	
	ResultObjStr importExcel(MultipartFile file, Integer myId);
	
	//ResultObjStr exportExcel(Integer myId, String fileName, String excelFormat, OutputStream fileOut);

}
