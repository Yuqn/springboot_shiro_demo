package com.yuqn.shiro_springboot.realm;

import com.yuqn.shiro_springboot.entity.User;
import com.yuqn.shiro_springboot.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * @author: yuqn
     * @Date: 2024/4/10 14:49
     * @description:
     * 自定义授权方法
     * @param: null
     * @return: null
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入到角色验证方法");
        // 1 获取用户信息
        String name = principalCollection.getPrimaryPrincipal().toString();
        // 2 调用接口请求数据库，获取用户角色信息，这里省略
        // 2.5 调用接口请求数据库，获取角色权限信息
        // 3 创建对象，封装当前登录用户的角色、权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("yuqn"); // 模拟查询角色名为yuqn
        info.addStringPermission("user:add"); // 模拟该角色的权限有 user:add
        // 4 返回信息
        return info;
    }

    /**
     * @author: yuqn
     * @Date: 2024/4/10 14:49
     * @description:
     * 自定义登录认证方法
     * @param: null
     * @return: null
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1、获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        // 2、获取数据库用户信息
        User user = userService.getUserInfoByName(name);
        // 3、判断，将数据封装返回
        if (user != null){
            AuthenticationInfo info = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    user.getPwd(),
                    ByteSource.Util.bytes("yuqn"),
                    authenticationToken.getPrincipal().toString()
            );
            System.out.println(info);
            return info;
        }
        return null;
    }
}
