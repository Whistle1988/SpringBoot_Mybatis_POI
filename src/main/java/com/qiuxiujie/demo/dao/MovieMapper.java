package com.qiuxiujie.demo.dao;

import com.qiuxiujie.demo.model.Movie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}