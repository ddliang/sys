package com.shiro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.sys.entity.OnLineUser;
import com.sys.entity.SysPermission;
import com.sys.entity.SysUser;
import com.sys.service.SysPermissionService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * <p>
 * Title: CustomRealm
 * </p>
 * <p>
 * Description:自定义realm
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2015-3-23下午4:54:47
 * @version 1.0
 */
public class CustomRealm extends AuthorizingRealm {
	private static Logger logger = Logger.getLogger(CustomRealm.class);
	@Autowired
	private SysPermissionService sysPermissionService;
	// 设置realm的名称
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	// 用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		SimpleAuthenticationInfo simpleAuthenticationInfo=null;
		try {


			// token是用户输入的
			// 第一步从token中取出身份信息
			String usercode = (String) token.getPrincipal();
			System.out.println("老子进来了");
			// 第二步：根据用户输入的userCode从数据库查询
			// ....
			if(usercode==null){//
				return null;
			}
			SysUser sysUser = new SysUser();
			sysUser = sysPermissionService.findSysUserByUserName(usercode);
			// 如果查询不到返回null
			//数据库中用户账号是zhangsansan
		/*if(!userCode.equals("zhangsansan")){
			return null;
		}*/
			// 如果查询不到返回null

			// 模拟从数据库查询到密码
			//String password = "111111";
			String password = sysUser.getPassword();
			//盐
			String salt = sysUser.getSalt();
			//activeUser就是用户身份信息
			OnLineUser activeUser = new OnLineUser();

			activeUser.setUserid(sysUser.getId());
			activeUser.setUsercode(sysUser.getUsercode());
			activeUser.setUsername(sysUser.getUsername());



			//查询用户用户的父菜单
			List<SysPermission> menus  = sysPermissionService.findMenuListByUserId(sysUser.getId());

			List<Map<String,List<SysPermission>>> list=new ArrayList<Map<String, List<SysPermission>>>();
			Map<String,String> param = new HashMap<String, String>();
			param.put("id",sysUser.getId());
			//查询子菜单
			for (SysPermission menu:  menus) {
				Map<String,List<SysPermission>> map =new HashMap<String, List<SysPermission>>();
				param.put("parentid",menu.getId().toString());
				List<SysPermission> permiss=sysPermissionService.findPermissionListByUserId(param);
				map.put(menu.getName(),permiss);
				String json = JSON.toJSONString(map);
				list.add(map);
				param.remove("parentid");
			}
			String json = JSON.toJSONString(list);




			//将用户菜单 设置到activeUser
			activeUser.setMenus(menus);
			// 如果查询到返回认证信息AuthenticationInfo

			 simpleAuthenticationInfo = new SimpleAuthenticationInfo(
					 activeUser, password, this.getName());
			return simpleAuthenticationInfo;
		}catch (Exception e){
			StringBuffer sb = new StringBuffer();
			sb.append("权限认证异常");
			logger.trace(sb.toString(),e);
		}

		return simpleAuthenticationInfo;

	}

	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		//从 principals获取主身份信息
		//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
		String userCode =  (String) principals.getPrimaryPrincipal();
		
		//根据身份信息获取权限信息
		//连接数据库...
		//模拟从数据库获取到数据
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:create");//用户的创建
		permissions.add("items:add");//商品添加权限
		//....
		
		//查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}

}
