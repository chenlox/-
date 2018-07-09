package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * @Description  Guru 业务逻辑层实现类，进行数据间的传输，对Dao传递过来的数据进行操作整理后传递至Controller
 * @Author  陈龙祥
 * @Time    2018-07-06 15:31:30
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDao gd;

    /**
     * @Description 传递数据以及返回值
     * @Author      陈龙祥
     * @Time        2018-07-06 15:31:30
     * @Param       控制层传递过来的Guru对象
     */
    @Override
    public int addGuru(Guru guru) {
        String id = UUID.randomUUID().toString().replace("-","");
        guru.setGuruId(id);
        return gd.insertGuru(guru);
    }

    /**
     * @Description 传递数据以及返回值
     * @Author      陈龙祥
     * @Time        2018-07-06 15:31:30
     * @Param       控制层传递过来的Guru对象
     */
    @Override
    public int modifyGuru(Guru guru) {
        return gd.updateGuru(guru);
    }


    /**
     * @Description 传递数据以及返回值
     * @Author      陈龙祥
     * @Time        2018-07-06 15:31:30
     * @Param       page:当前页数       rows:每页显示行数
     */
    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Map<String, Object> queryAllGuru(String value,Integer page, Integer rows) {
        String value1 = null;
        if(value != null){
            value1 = "%"+value+"%";
        }
        System.out.println(value);
        System.out.println(value1);
        List<Guru> gurus = gd.selectAllGuru(value1,(page - 1) * rows, rows);
        System.out.println(gurus);
        int count = gd.count(value1);
        Map<String, Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    public List<Guru> queryAll() {
        return gd.selectAll();
    }
}
