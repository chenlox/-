package com.baizhi.cmfz.service;


import com.baizhi.cmfz.entity.Log;

import java.util.Map;

/**
 * @Description  Log 业务逻辑层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-09 19:02:30
 */
public interface LogService {

    public int addLog(Log log);


    public Map<String,Object> queryAllLog(Integer page,Integer rows);

}
