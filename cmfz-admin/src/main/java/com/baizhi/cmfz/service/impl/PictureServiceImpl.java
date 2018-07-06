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
import java.util.UUID;


/**
 * @Description 轮播图  业务逻辑层实现类，进行数据间的传输，对Dao传递过来的数据进行操作整理后传递至Controller
 * @Author  陈龙祥
 * @Time    2018-07-05 15:20:30
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pd;

    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Map<String,Object> queryAllPicture(Integer page, Integer rows) {
        Integer nowPage = (page - 1) * rows;
        List<Picture> pictures = pd.selectAllPicture(nowPage, rows);
        Integer count = pd.selectCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",pictures);
        return map;
    }

    @Override
    public int addPicture(Picture pic) {
        String id = UUID.randomUUID().toString().replace("-","");
        pic.setPictureId(id);
        return pd.insertPicture(pic);
    }

    @Override
    public int modifyPicture(Picture pic) {
        System.out.println(pic);
        return pd.updatePicture(pic);
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Picture queryPicture(String pictureId) {
        return pd.selectPicture(pictureId);
    }


}
