package com.jk.config;


import com.jk.model.SysPermission;
import com.jk.model.SysUser;
import com.jk.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 授权器
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        //获得当前用户信息
//        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
//        List<String> permissionList = new ArrayList<String>();
//        //查询当前用户拥有的所有权限集合
//        List<SysPermission> permissions = sysUserService.findPermissionByUserId(sysUser.getUid());
//        for(SysPermission sysPermission : permissions) {
//            permissionList.add(sysPermission.getPermission());
//        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }


    /**
     * 认证器
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //第一步：获得前台的用户名
        String username = (String) token.getPrincipal();
        //去数据库中查询用户信息
        SysUser sysUser = sysUserService.findUserByUsername(username);
        //判断当前用户是否存在
        if (sysUser == null) {
            return null;
        }
        //查询当前用户左侧菜单信息
        List<SysPermission> permissionList = sysUserService.findMenuByUserId(sysUser.getId());
        sysUser.setMenuList(permissionList);

        // 验证页面输入的密码和当前获取的用户信息对象中加盐的密码进行比较
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()), getName());
        return simpleAuthenticationInfo;
    }
}