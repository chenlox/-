package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao md;


    /**
     * @Description 对查询到的数据进行逻辑判断，并传递给控制层
     * @Author      陈龙祥
     * @Time        2018-07-04 15：13;00
     * @Param       控制层传递过来的Manager对象
     */
    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Manager queryManager(Manager mgr) {
        Manager manager = md.selectManager(mgr.getManagerId());
        if(manager != null){
            if(manager.getManagerPassword().equals(mgr.getManagerPassword())){
                return manager;
            }
        }
        return null;
    }
}
