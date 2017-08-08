package com.sys.dao;


import com.sys.entity.SysPermission;

import java.util.List;

public interface SysPermissionMapper {
    //根据用户id查询菜单
    public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
    //根据用户id查询权限url
    public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;
}