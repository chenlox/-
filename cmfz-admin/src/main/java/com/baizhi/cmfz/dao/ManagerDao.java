package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Description 数据访问层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-04 14:58:30
 */
public interface ManagerDao {

    public Manager selectManager(@Param("managerName") String managerName);

    public int insertManager(Manager mgr);

    public List<Role> selectRolesByManagername(String managerName);

    public List<Permission> selectPermissionByManagername(String managerName);



}
