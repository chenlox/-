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


/**
 * @Description 菜单控制层,控制页面跳转
 * @Author  陈龙祥
 * @Time    2018-07-05 11:30:30
 */
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

}
