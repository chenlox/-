package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService ms;

    @RequestMapping("/login")
    public String login(Manager mgr, String enCode, HttpSession session){
        String code = (String) session.getAttribute("code");
        if(enCode == null || !enCode.equalsIgnoreCase(code)){
            return "redirect:/login.jsp";
        }
        Manager manager = ms.queryManager(mgr);
        if(manager != null){
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/register")
    public String register(Manager mgr){
        int result = ms.addManager(mgr);
        if(result > 0){
            return "redirect:/login.jsp";
        }
        return "redirect:/register.jsp";
    }

}
