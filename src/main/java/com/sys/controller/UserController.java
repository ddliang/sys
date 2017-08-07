package com.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sys.entity.SysUser;
import com.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by DaiLiang on 2017/8/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request )throws Exception{

        /*//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //最终会抛给异常处理器
                //throw new CustomException("账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
               // throw new CustomException("用户名/密码错误");
            } else if("randomCodeError".equals(exceptionClassName)){
               // throw new CustomException("验证码错误 ");
            }else {
                throw new Exception();//最终在异常处理器生成未知错误
            }
        }
        //此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
        //登陆失败还到login页面
        return "login2";*/
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            subject.login(token);
           /* 分页测试开始*/
            PageHelper.startPage(1, 10);
            List<SysUser> list = sysUserService.selectByPage5("0");
            for (SysUser user: list) {
                System.out.println(user.getUsername());
            }
            // 取分页信息
            PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
            long total = pageInfo.getTotal(); //获取总记录数
            System.out.println("共有商品信息：" + total);
            System.out.println("共有多少页：" + pageInfo.getPages());
              /* 分页测试结束*/
            request.getSession().setAttribute("url", "home.jsp");
            return "index";
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("error", "用户名或密码错误");
            return "login2";
        }
    }

    @RequestMapping("/loginSuc")
    public String loginSuccess(Model model){
        System.out.println("登录成功了");
        return "sucess";
    }
    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("-------------------------");
        return "home";
    }
}
