package com.qiuxiujie.demo.service.impl;

import com.qiuxiujie.demo.dao.DataMapper;
import com.qiuxiujie.demo.poi.excel.ExcelUtil;
import com.qiuxiujie.demo.service.DataImportService;
import com.qiuxiujie.demo.util.ResultObjStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataImportServiceImpl implements DataImportService {

    private static Logger logger = LoggerFactory.getLogger(SiteInfoServiceImpl.class);
    @Autowired
    private DataMapper dataMapper;
    @Override
    public ResultObjStr importExcel(MultipartFile file, Integer myId){
        List<Map<String, Object>> excelsMap = new ArrayList<>();
        InputStream in = null;
        try {
            in = file.getInputStream();
            List<List<Object>> excels = ExcelUtil.readExcel(in);
            for (int i = 0; i < excels.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                for (int j = 0; j < excels.get(i).size(); j++) {
                    switch (j) {
                        case 0:
                            map.put("id", excels.get(i).get(j));
                            break;
                        case 1:
                            //System.out.println(excels.get(i).get(j));
                            map.put("types", excels.get(i).get(j));
                            break;
                        case 2:
                            map.put("brand", excels.get(i).get(j));
                            break;
                        case 3:
                            map.put("numColor", excels.get(i).get(j));
                            break;
                        case 4:
                            map.put("announcedTime", excels.get(i).get(j));
                            break;
                        case 5:
                            map.put("marketPosition", excels.get(i).get(j));
                            break;
                        case 6:
                            map.put("chipPlatform", excels.get(i).get(j));
                            break;
                        case 7:
                            map.put("chipFreq", excels.get(i).get(j));
                            break;
                        case 8:
                            map.put("ap", excels.get(i).get(j));
                            break;
                        case 9:
                            map.put("numFreq", excels.get(i).get(j));
                            break;
                        case 10:
                            map.put("price", excels.get(i).get(j));
                            break;
                        case 11:
                            map.put("lookType", excels.get(i).get(j));
                            break;
                        case 12:
                            map.put("thickness", excels.get(i).get(j));
                            break;
                        case 13:
                            map.put("weight", excels.get(i).get(j));
                            break;
                        case 14:
                            map.put("numScreen", excels.get(i).get(j));
                            break;
                        case 15:
                            map.put("sizeScreen", excels.get(i).get(j));
                            break;
                        case 16:
                            map.put("ratio", excels.get(i).get(j));
                            break;
                        case 17:
                            map.put("touchScreen", excels.get(i).get(j));
                            break;
                        case 18:
                            map.put("keyboardType", excels.get(i).get(j));
                            break;
                        case 19:
                            map.put("ram", excels.get(i).get(j));
                            break;
                        case 20:
                            map.put("rom", excels.get(i).get(j));
                            break;
                        case 21:
                            map.put("flash", excels.get(i).get(j));
                            break;
                        case 22:
                            map.put("camera", excels.get(i).get(j));
                            break;
                        case 23:
                            map.put("positions", excels.get(i).get(j));
                            break;
                        case 24:
                            map.put("fm", excels.get(i).get(j));
                            break;
                        case 25:
                            map.put("tv", excels.get(i).get(j));
                            break;
                        case 26:
                            map.put("modem", excels.get(i).get(j));
                            break;
                        case 27:
                            map.put("infrared", excels.get(i).get(j));
                            break;
                        case 28:
                            map.put("bluetooth", excels.get(i).get(j));
                            break;
                        case 29:
                            map.put("wlann", excels.get(i).get(j));
                            break;
                        case 30:
                            map.put("battery", excels.get(i).get(j));
                            break;
                        case 31:
                            map.put("gravity", excels.get(i).get(j));
                            break;
                        case 32:
                            map.put("direction", excels.get(i).get(j));
                            break;
                        case 33:
                            map.put("numTextMethod", excels.get(i).get(j));
                            break;
                        case 34:
                            map.put("intelliSys", excels.get(i).get(j));
                            break;
                        default:
                            break;
                    }

                }
                excelsMap.add(map);

                //System.out.println(map);
            }
            this.dataMapper.addMultSiteInfo(excelsMap);
            return new ResultObjStr(ResultObjStr.SUCCESS, "上传成功", null);
        } catch (IOException e) {
            logger.error("导入 siteInfo excel 错误 : " + e.getMessage());
            return new ResultObjStr(ResultObjStr.ERROR,"上传错误",null);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("导入 siteInfo excel 关流错误 : " + e.getMessage());
                return new ResultObjStr(ResultObjStr.ERROR,"上传错误",null);
            }
        }
    }

}
