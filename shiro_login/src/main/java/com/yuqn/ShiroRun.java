package com.yuqn;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroRun {
    public static void main(String[] args) {
        // 1、初始化获取securityManager
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 2、获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 3、创建token对象
        AuthenticationToken token = new UsernamePasswordToken("yuqn","idiot");
        try {
            // 4、完成登录
            subject.login(token);
            System.out.println("登录成功");
            // 5、判断角色
            boolean isgo = subject.hasRole("student");
            System.out.println(isgo);
            // 6、判断权限
            boolean isRole = subject.isPermitted("user:delete");
            System.out.println(isRole);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
