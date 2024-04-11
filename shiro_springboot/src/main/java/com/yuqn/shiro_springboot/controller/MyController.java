package com.yuqn.shiro_springboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("myController")
public class MyController {
    @GetMapping("userLogin")
    @ResponseBody
    public String userLogin(String name,String pwd){
        // 1获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 2封装请求数据到token
        AuthenticationToken token = new UsernamePasswordToken(name,pwd);
        // 3调用login方法进行登录认证
        try{
            subject.login(token);
            return "登录成功";
        }catch(AuthenticationException e){
            e.printStackTrace();
            System.out.println("登录失败");
            return "登录失败";
        }
    }

    // 登录验证角色
    @RequiresRoles("yuqn")
    @GetMapping("userLoginRoles")
    @ResponseBody
    public String userLoginRoles(){
        System.out.println("角色验证成功");
        return null;
    }

    // 登录验证角色权限
    @RequiresPermissions("user:add")
    @GetMapping("userLoginPermissions")
    @ResponseBody
    public String userLoginPermissions(){
        System.out.println("角色权限验证成功");
        return null;
    }


}
