package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * @Description 菜单 数据访问层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-05 09:58:30
 */
public interface MenuDao {

    public List<Menu> selectMenu();

}
