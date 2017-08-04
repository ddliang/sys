package com.sys.dao;


import com.sys.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SysUserMapper {


    List<SysUser> selectByExample();

    List<SysUser> selectByPage();

}