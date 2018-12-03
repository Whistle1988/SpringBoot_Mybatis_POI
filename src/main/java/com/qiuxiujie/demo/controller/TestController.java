package com.qiuxiujie.demo.controller;

import com.qiuxiujie.demo.model.Movie;
import com.qiuxiujie.demo.service.ISiteInfoService;
import com.qiuxiujie.demo.service.MovieService;
import com.qiuxiujie.demo.service.impl.MovieServiceImpl;
import com.qiuxiujie.demo.util.ResultObjStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/siteInfo")
public class TestController {

    @Autowired
    private MovieServiceImpl movieService;
    @Autowired
    private ISiteInfoService siteInfoService;
    @RequestMapping("/test")
    public String test(Model model){
        Movie mv = movieService.testMybatis();
        model.addAttribute("movie", mv);
        return "test";
    }

    @ResponseBody
    @PostMapping(value = "/importExcel")
    public String importExcel (@RequestParam("file") MultipartFile file, Integer myid) {
        try {
            return siteInfoService.importExcel(file, myid).toJson();
        } catch (Exception e) {
            //logger.error("上传excel后台错误 : " + e.getMessage());
            return new ResultObjStr(ResultObjStr.ERROR, "后台错误", null).toJson();
        }
    }
}
