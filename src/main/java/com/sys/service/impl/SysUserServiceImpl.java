package com.sys.service.impl;

import com.sys.dao.SysUserMapper;
import com.sys.entity.SysUser;
import com.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author:DaiLiang
 * @Description:
 * @Create: 2017-07-31 16:46
 */
@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserMapper userDao;
    public List<SysUser> selectByExample() {
        return userDao.selectByExample();
    }

    public List<SysUser> selectByPage() {
        return userDao.selectByPage();
    }
}
