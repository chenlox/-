package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description Guru控制层,控制页面跳转
 * @Author  陈龙祥
 * @Time    2018-07-06 15:45:30
 */
@Controller
@RequestMapping("/Guru")
public class GuruController {

    @Autowired
    private GuruService gs;


    /**
     * @Description 将数据库查询到的信息转化为json字符串返回至前端
     * @Author      陈龙祥
     * @Time        2018-07-06 15:45:30
     * @Param       添加的Guru对象
     */
    @RequestMapping("/addGuru")
    @ResponseBody
    public int addGuru(Guru guru, MultipartFile file, HttpSession session) throws IOException {
        String realPath=session.getServletContext().getRealPath("/");
        int lastIndexOf=realPath.lastIndexOf("\\");
        String substring=realPath.substring(0,lastIndexOf);
        int lastIndexOf1=substring.lastIndexOf("\\");
        String substring1=realPath.substring(0,lastIndexOf1);
        String uploadPath=substring1+"\\upload\\guru-img";
        String picPath=file.getOriginalFilename();
        guru.setGuruPhoto(picPath);
        file.transferTo(new File(uploadPath+"\\"+picPath));
        return gs.addGuru(guru);
    }


    /**
     * @Description 将数据库查询到的信息转化为json字符串返回至前端
     * @Author      陈龙祥
     * @Time        2018-07-06 15:45:30
     * @Param       修改之后的Guru对象
     */
    @RequestMapping("/modifyGuru")
    @ResponseBody
    public int modifyGuru(Guru guru){
        return gs.modifyGuru(guru);
    }


    /**
     * @Description 将数据库查询到的信息转化为json字符串返回至前端
     * @Author      陈龙祥
     * @Time        2018-07-06 15:45:30
     * @Param       name:进行模糊查询的条件(上师法名)    page:当前页数    rows:每页显示行数
     */
    @RequestMapping("/showAllGuru")
    @ResponseBody
    public Map<String,Object> showAllGuru(String value,Integer page,Integer rows){
        return gs.queryAllGuru(value,page,rows);
    }


    @RequestMapping("/addAllGuru")
    @ResponseBody
    public int addAllGuru(MultipartFile file) throws Exception {
        ImportParams params = new ImportParams();
        List<Guru> gurus  = ExcelImportUtil.importExcel(file.getInputStream(), Guru.class, params);
        for (Guru guru : gurus) {
            gs.addGuru(guru);
        }
        return 1;

    }
}
