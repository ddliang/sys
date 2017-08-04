package test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sys.entity.SysUser;
import com.sys.service.SysUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author:DaiLiang
 * @Description:   mybatis 分页插件测试
 * @Create: 2017-08-04 11:28
 */
public class PageHelperTest {
    @Test
    public void testPageHelper(){
        // 创建一个spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-*");
        // 从spring容器中获取mapper代理对象
        SysUserService mapper = context.getBean(SysUserService.class);
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(1,10);
        //获取分页数据
        List<SysUser> list = mapper.selectByPage();
        for (SysUser user: list) {
                System.out.println(user.getUsername());
        }
        // 取分页信息
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
        long total = pageInfo.getTotal(); //获取总记录数
        System.out.println("共有商品信息：" + total);
    }
}
