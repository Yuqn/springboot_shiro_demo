package com.yuqn;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取身份信息
        String principal = authenticationToken.getPrincipal().toString();
        System.out.println("principal = " + principal);
        // 获取凭证信息
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println("password = " + password);

        if("yuqn".equals(principal)){
            String pwdInfo = "36795b292a0e4cf7a37659f903aca301";
            System.out.println("\"验证通过\" = " + "验证通过");
            AuthenticationInfo info = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    pwdInfo,
                    ByteSource.Util.bytes("yuqn"),
                    authenticationToken.getPrincipal().toString()
            );
            return info;
        }
        return null;

    }
}
