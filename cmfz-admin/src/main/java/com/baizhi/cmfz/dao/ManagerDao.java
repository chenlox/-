package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;


/**
 * @Description 数据访问层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-04 14:58:30
 */
public interface ManagerDao {

    public Manager selectManager(@Param("managerName") String managerName);

    public int insertManager(Manager mgr);

}
