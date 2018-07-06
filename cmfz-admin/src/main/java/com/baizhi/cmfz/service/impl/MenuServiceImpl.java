package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Description 菜单  业务逻辑层实现类，进行数据间的传输，对Dao传递过来的数据进行操作整理后传递至Controller
 * @Author  陈龙祥
 * @Time    2018-07-05 10:20:30
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao md;

    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public List<Menu> queryMenu() {

       return md.selectMenu();

    }
}
