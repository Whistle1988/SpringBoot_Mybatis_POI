package com.qiuxiujie.demo.dao;

import com.qiuxiujie.demo.model.Datas;

import java.util.List;
import java.util.Map;

public interface DataMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Datas record);
//
//    int insertSelective(Datas record);
//
//    Datas selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Datas record);
//
//    int updateByPrimaryKey(Datas record);

    Integer addMultSiteInfo(List<Map<String, Object>> list);
}