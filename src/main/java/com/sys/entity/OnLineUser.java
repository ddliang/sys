package com.sys.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:DaiLiang
 * @Description: 在线用户实体
 * @Create: 2017-08-17 15:30
 */
public class OnLineUser {
    private String userid;//用户id（主键）
    private String usercode;// 用户账号
    private String username;// 用户名称

    private List<Map<String,List<SysPermission>>> maps = new ArrayList<Map<String, List<SysPermission>>>();
    private List<SysPermission> menus;// 菜单
    private List<SysPermission> permissions;// 权限

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<SysPermission> getMenus() {
        return menus;
    }

    public void setMenus(List<SysPermission> menus) {
        this.menus = menus;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<Map<String, List<SysPermission>>> getMaps() {
        return maps;
    }

    public void setMaps(List<Map<String, List<SysPermission>>> maps) {
        this.maps = maps;
    }
}
