package com.sys.service;

import com.sys.entity.SysPermission;

import java.util.List;

/**
 * @Author:DaiLiang
 * @Description:
 * @Create: 2017-08-08 10:33
 */
public interface SysPermissionService {
    //根据用户id查询菜单
    public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
    //根据用户id查询权限url
    public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;
}
