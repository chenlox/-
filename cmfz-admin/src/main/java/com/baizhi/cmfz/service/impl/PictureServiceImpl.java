package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pd;

    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Map<Integer,Object> queryAllPicture(Integer page, Integer rows) {
        Integer nowPage = (page - 1) * rows;
        List<Picture> pictures = pd.selectAllPicture(nowPage, rows);
        Integer count = pd.selectCount();
        Map<Integer,Object> map = new HashMap<Integer,Object>();
        map.put(count,pictures);
        return map;
    }
}
