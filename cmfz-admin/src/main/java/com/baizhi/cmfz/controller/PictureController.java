package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * @Description 轮播图控制层,控制页面跳转
 * @Author  陈龙祥
 * @Time    2018-07-05 20:30:30
 */
@Controller
@RequestMapping("/Picture")
public class PictureController {

    @Autowired
    private PictureService ps;

    @RequestMapping("/showPicture")
    @ResponseBody
    public Picture showPicture(String pictureId){
        return ps.queryPicture(pictureId);
    }

    @RequestMapping("/showAllPicture")
    @ResponseBody
    public Map<String,Object> showAllPicture(Integer page, Integer rows){
        return ps.queryAllPicture(page, rows);
    }

    @RequestMapping("/addPicture")
    @ResponseBody
    public int add(MultipartFile file, HttpSession session, Picture pic) throws IOException {
        String realPath=session.getServletContext().getRealPath("/");
        int lastIndexOf=realPath.lastIndexOf("\\");
        String substring=realPath.substring(0,lastIndexOf);
        int lastIndexOf1=substring.lastIndexOf("\\");
        String substring1=realPath.substring(0,lastIndexOf1);
        String uploadPath=substring1+"\\upload";
        String picPath=file.getOriginalFilename();
        pic.setPicturePath(picPath);
        file.transferTo(new File(uploadPath+"\\"+picPath));
        return ps.addPicture(pic);
    }

    @RequestMapping("/modifyPicture")
    @ResponseBody
    public int update(Picture pic){
        return ps.modifyPicture(pic);
    }

}
