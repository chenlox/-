package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;


/**
 * @Description 业务逻辑层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-04 15:18:30
 */
public interface ManagerService {

    public Manager queryManager(Manager mgr);

    public int addManager(Manager mgr);

    public List<Role> queryRolesByManagername(String managerName);

    public List<Permission> queryPermissionByManagername(String managerName);

}
