package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerDao {

    public Manager selectManager(@Param("managerName") String managerName);

    public int insertManager(Manager mgr);

}
