package com.sys.service.impl;

import com.sys.dao.SysPermissionMapper;
import com.sys.entity.SysPermission;
import com.sys.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
        return permissionMapper.findPermissionListByUserId(userid);
    }
}
