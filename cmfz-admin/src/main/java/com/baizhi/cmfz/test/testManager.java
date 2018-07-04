package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testManager {
    public static void main(String[] args) {
        testRegister();
    }


    private static void test1(){
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ManagerDao managerDao = (ManagerDao)classPathXmlApplicationContext.getBean("managerDao");
        Manager manager= managerDao.selectManager("tom");
        System.out.println(manager);
    }

    public static void testRegister(){
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ManagerService managerService = (ManagerService)classPathXmlApplicationContext.getBean("managerServiceImpl");
        int result = managerService.addManager(new Manager("2222","rose","123456","1"));
        System.out.println(result);
    }



}
