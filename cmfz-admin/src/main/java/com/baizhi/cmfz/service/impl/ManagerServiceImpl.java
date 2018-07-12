package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


/**
 * @Description 业务逻辑层实现类，进行数据间的传输，对Dao传递过来的数据进行操作整理后传递至Controller
 * @Author  陈龙祥
 * @Time    2018-07-04 15:20:30
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao md;


    /**
     * @Description 对查询到的数据进行逻辑判断，并传递给控制层
     * @Author      陈龙祥
     * @Time        2018-07-04 15：13;00
     * @Param       控制层传递过来的Manager对象
     */
    @Override
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public Manager queryManager(Manager mgr) {
        Manager manager = md.selectManager(mgr.getManagerName());
        /*if(manager != null){
            String s = mgr.getManagerPassword()+""+manager.getSalt();
            String password = DigestUtils.md5Hex(s);
            if(manager.getManagerPassword().equals(password)){
                return manager;
            }
        }*/
        return manager;

    }

    @Override
    public int addManager(Manager mgr) {
        String id = UUID.randomUUID().toString().replace("-","");
        mgr.setManagerId(id);
        String salt = EncryptionUtils.getRandomSalt(6);
        System.out.println(salt);
        mgr.setSalt(salt);
        //String s = mgr.getManagerPassword()+""+salt;
        Md5Hash md5Hash = new Md5Hash(mgr.getManagerPassword(), salt, 1024);
        //String password = DigestUtils.md5Hex(s);
        mgr.setManagerPassword(md5Hash.toString());
        System.out.println(mgr);
        return md.insertManager(mgr);
    }

    @Override
    public List<Role> queryRolesByManagername(String managerName) {
        return md.selectRolesByManagername(managerName);
    }

    @Override
    public List<Permission> queryPermissionByManagername(String managerName) {
        return md.selectPermissionByManagername(managerName);
    }
}
