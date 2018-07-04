package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService ms;

    @RequestMapping("/select")
    public String searchManager(Manager mgr){
        Manager manager = ms.queryManager(mgr);
        if(manager != null){
            return "index";
        }
        return "login";
    }

}
