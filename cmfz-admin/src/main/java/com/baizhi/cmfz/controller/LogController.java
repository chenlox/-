package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/Log")
public class LogController {

    @Autowired
    private LogService ls;


    @RequestMapping("/addLog")
    @ResponseBody
    public int addLog(Log log){
        return ls.addLog(log);
    }

    @RequestMapping("/showAllLog")
    @ResponseBody
    public Map<String,Object> showAll(Integer page,Integer rows){
        return ls.queryAllLog(page,rows);
    }
}
