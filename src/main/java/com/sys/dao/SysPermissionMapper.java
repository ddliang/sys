package com.sys.dao;


import com.sys.entity.SysPermission;
import com.sys.entity.SysUser;

import java.util.List;
import java.util.Map;

public interface SysPermissionMapper {
    //根据用户id查询菜单
    public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
    //根据用户id查询权限(子菜单)
    public List<SysPermission> findPermissionListByUserId(Map<String,String> map)throws Exception;
    //根据用户账号查询用户信息
    public SysUser findSysUserByUserName(String usercode)throws Exception;
}