package com.baizhi.cmfz.service;


import com.baizhi.cmfz.entity.Guru;

import java.util.Map;

/**
 * @Description  Guru 业务逻辑层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-06 15:27:30
 */
public interface GuruService {

    public int addGuru(Guru guru);

    public int modifyGuru(Guru guru);

    public Map<String,Object> queryAllGuru(String value,Integer page, Integer rows);

}
