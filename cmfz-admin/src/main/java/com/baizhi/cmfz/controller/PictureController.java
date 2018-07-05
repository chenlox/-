package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/Picture")
public class PictureController {

    @Autowired
    private PictureService ps;

    @RequestMapping("/showAllPicture")
    @ResponseBody
    public Map<String,Object> showAllPicture(Integer page, Integer rows){
        Map<String, Object> map = ps.queryAllPicture(page, rows);
        System.out.println(map);
        return map;
    }

}
