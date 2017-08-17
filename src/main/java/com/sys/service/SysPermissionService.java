package com.sys.service;

import com.sys.entity.SysPermission;
import com.sys.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @Author:DaiLiang
 * @Description:
 * @Create: 2017-08-08 10:33
 */
public interface SysPermissionService {
    //根据用户id查询菜单
    public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
    //根据用户id查询权限(子菜单)
    public List<SysPermission> findPermissionListByUserId(Map<String,String> map)throws Exception;
    //根据用户账号查询用户信息
    public SysUser findSysUserByUserName(String userName)throws Exception;
}
