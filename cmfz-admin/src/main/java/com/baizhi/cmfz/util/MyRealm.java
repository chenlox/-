package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService ms;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("-----------------进入到获取授权信息的方法---------------");

        String managerName = (String) principalCollection.getPrimaryPrincipal();

        List<Role> roles = ms.queryRolesByManagername(managerName);
        //封装查询到的授权对象信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            //将角色标签保存至返回值
            info.addRole(role.getRoleTag());
        }

        List<Permission> permissions = ms.queryPermissionByManagername(managerName);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("----------------------------------------");

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        //获得前台输入的用户名
        String username = usernamePasswordToken.getUsername();

        Manager mgr = new Manager();

        mgr.setManagerName(username);

        Manager manager = ms.queryManager(mgr);

        if(manager != null){
            return new SimpleAuthenticationInfo(manager.getManagerName(),manager.getManagerPassword(),ByteSource.Util.bytes(manager.getSalt()), UUID.randomUUID().toString());
        }

        return null;
    }
}
