package com.sys.service.impl;

import com.sys.dao.SysPermissionMapper;
import com.sys.entity.SysPermission;
import com.sys.entity.SysUser;
import com.sys.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author:DaiLiang
 * @Description:
 * @Create: 2017-08-08 10:34
 */
@Service
public class SysPermissionImp implements SysPermissionService{
    @Autowired
    private SysPermissionMapper permissionMapper;
    public List<SysPermission> findMenuListByUserId(String userid) throws Exception {
        return permissionMapper.findMenuListByUserId(userid);
    }

    public List<SysPermission> findPermissionListByUserId(Map<String, String> map) throws Exception {
        return permissionMapper.findPermissionListByUserId(map);
    }


    public SysUser findSysUserByUserName(String userName) throws Exception {
        return permissionMapper.findSysUserByUserName(userName);
    }
}
