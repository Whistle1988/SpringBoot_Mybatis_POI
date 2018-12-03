package com.qiuxiujie.demo.service.impl;

import com.qiuxiujie.demo.dao.MovieMapper;
import com.qiuxiujie.demo.model.Movie;
import com.qiuxiujie.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Movie testMybatis(){
        return movieMapper.selectByPrimaryKey(1);
    }
}
