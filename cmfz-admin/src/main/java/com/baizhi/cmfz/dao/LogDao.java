package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Description Log 数据访问层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-09 18:45:30
 */
public interface LogDao {

    public int insertLog(Log log);


    public List<Log> selectAllLog(@Param("page") Integer page, @Param("rows") Integer rows);


    public int count();


}
