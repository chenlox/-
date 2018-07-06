package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Description 轮播图 数据访问层接口，定义方法
 * @Author  陈龙祥
 * @Time    2018-07-05 14:58:30
 */
public interface PictureDao {

    public List<Picture> selectAllPicture(@Param("page") Integer nowPage, @Param("rows") Integer rows);

    public Integer selectCount();

    public int insertPicture(Picture pic);

    public int updatePicture(Picture pic);

    public Picture selectPicture(@Param("pictureId") String pictureId);



}
