package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description 管理员控制层,控制页面跳转
 * @Author  陈龙祥
 * @Time    2018-07-04 15:30:30
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService ms;

    @RequestMapping("/login")
    public String login(String click, Manager mgr, String enCode, HttpSession session, HttpServletResponse response,Boolean rememberMe) throws UnsupportedEncodingException {
        String code = (String) session.getAttribute("code");
        System.out.println(rememberMe);
        if(enCode == null || !enCode.equalsIgnoreCase(code)){
            return "redirect:/login.jsp";
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(mgr.getManagerName(),mgr.getManagerPassword(),rememberMe));
            /*Manager manager = ms.queryManager(mgr);
            session.setAttribute("manager",manager);*/
            if(click != null){
                Cookie c1 = new Cookie("name",URLEncoder.encode(mgr.getManagerName(),"UTF-8"));
                Cookie c2 = new Cookie("password",mgr.getManagerPassword());
                response.addCookie(c1);
                response.addCookie(c2);
                c1.setMaxAge(60*60*24);
                c1.setMaxAge(60*60*24);
            }else{
                Cookie c1 = new Cookie("name",null);
                Cookie c2 = new Cookie("password",null);
                response.addCookie(c1);
                response.addCookie(c2);
            }
            return "redirect:/main.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "redirect:/login.jsp";
        } catch (IncorrectCredentialsException ice){
            ice.printStackTrace();
            return "redirect:/login.jsp";
        } catch (AuthenticationException ae){
            ae.printStackTrace();
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/register")
    public String register(Manager mgr){
        int result = ms.addManager(mgr);
        if(result > 0){
            return "redirect:/login.jsp";
        }
        return "redirect:/register.jsp";
    }

    @RequestMapping("/getCookie")
    @ResponseBody
    public List<String> getCookie(HttpServletRequest request) throws UnsupportedEncodingException {
        List<String> lists = new ArrayList<String>();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("name")){
                lists.add(URLDecoder.decode(cookie.getValue(),"utf-8"));
            }else if(cookie.getName().equals("password")){
                lists.add(cookie.getValue());
            }
        }
        return lists;
    }

}
