package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;


/**
 * @Description 轮播图 业务逻辑层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-05 15:18:30
 */
public interface PictureService {

    public Map<String,Object> queryAllPicture(Integer page, Integer rows);

    public int addPicture(Picture pic);

    public int modifyPicture(Picture pic);

    public Picture queryPicture(String pictureId);

}
