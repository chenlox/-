package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.List;
import java.util.Map;

public interface PictureService {


    public Map<String,Object> queryAllPicture(Integer page, Integer rows);

}
