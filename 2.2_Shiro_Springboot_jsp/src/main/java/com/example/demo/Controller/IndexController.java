package com.example.demo.Controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class IndexController {

    @Autowired
    private UserService service;

    @RequestMapping("login")
    public String login(String username,String password){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("正确");
            return "redirect:/index.jsp";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }

        System.out.println("跳转至主页");
       // return "redirect:/index.jsp";

        return "redirect:/login.jsp";
    }
    @RequestMapping("index")
    public String index(){
        System.out.println("跳转至主页");
        return "redirect:/index.jsp";
    }


    @RequestMapping("register")
    public String register(User user){
        try {
            service.register(user);
            System.out.println("注册成功");
            return "redirect:/login.jsp";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/error.jsp";
        }

    }

//    @RequestMapping("save")
//    public String save(){
//        System.out.println("进入方法");
//        //获取主体对象
//        Subject subject = SecurityUtils.getSubject();
//        //代码方式
//        if (subject.hasRole("admin")) {
//            System.out.println("保存订单!");
//        }else{
//            System.out.println("无权访问!");
//        }
//        //基于权限字符串
//        //....
//        return "redirect:/index.jsp";
//    }


    @RequiresRoles(value={"admin","user"})//用来判断角色  同时具有 admin user
    @RequiresPermissions("user:update:01") //用来判断权限字符串
    @RequestMapping("save")
    public String save(){
        System.out.println("进入方法");
        return "redirect:/index.jsp";
    }



}
