package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description  Log 业务逻辑层实现类，进行数据间的传输，对Dao传递过来的数据进行操作整理后传递至Controller
 * @Author  陈龙祥
 * @Time    2018-07-09 19:05:30
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao ld;

    @Override
    @Transactional
    public int addLog(Log log) {
        String id = UUID.randomUUID().toString().replace("-","");
        log.setLogId(id);
        return ld.insertLog(log);
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Map<String, Object> queryAllLog(Integer page, Integer rows) {
        List<Log> logs = ld.selectAllLog((page - 1) * rows, rows);
        int count = ld.count();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",logs);
        return map;
    }
}
