package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureDao {

    public List<Picture> selectAllPicture(@Param("page") Integer nowPage, @Param("rows") Integer rows);

    public Integer selectCount();



}
