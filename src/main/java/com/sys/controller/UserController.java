package com.sys.controller;

import com.sys.entity.SysUser;
import com.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author:DaiLiang
 * @Description:
 * @Create: 2017-07-31 16:48
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SysUserService userService;

    @RequestMapping("/test")
    public String RefundDetail(Model model, HttpServletResponse response, HttpServletRequest request){
        List<SysUser>  list = userService.selectByExample();
        for (SysUser user: list) {
            System.out.println(user.getUsername());
        }
        return "index2";
    }

}
