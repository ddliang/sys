package com.sys.service;

import com.sys.entity.SysUser;

import java.util.List;

/**
 * @Author:DaiLiang
 * @Description:
 * @Create: 2017-07-31 16:44
 */
public interface SysUserService {
    List<SysUser> selectByExample();

    List<SysUser> selectByPage();

    List<SysUser> selectByPage5(String id);
}
