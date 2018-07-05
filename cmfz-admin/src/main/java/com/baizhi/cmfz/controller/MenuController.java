package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/Menu")
@SessionAttributes(value = "menus")
public class MenuController {

    @Autowired
    private MenuService ms;

    @RequestMapping("/showMenu")
    @ResponseBody
    public List<Menu> showMenu(){
        List<Menu> menus = ms.queryMenu();
        return menus;
    }
   /* public String showMenu(Model model){
        List<Menu> menus = ms.queryMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
        model.addAttribute("menus",menus);

        return "redirect:/main.jsp";

    }*/


}
