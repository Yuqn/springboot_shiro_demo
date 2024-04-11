package com.yuqn;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroMd5 {
    public static void main(String[] args) {
        // 密码明文
        String password = "123456";
        // 使用md5加密
        Md5Hash md5Hash = new Md5Hash(password);
        // 输出
        System.out.println("md5Hash = " + md5Hash.toHex());
        // 加盐
        Md5Hash md5Hash1 = new Md5Hash(password,"yuqn");
        // 输出
        System.out.println("md5Hash1 = " + md5Hash1.toHex());
        // 加盐迭代加密
        Md5Hash md5Hash2 = new Md5Hash(password,"yuqn",2);
        // 输出
        System.out.println("md5Hash2 = " + md5Hash2.toHex());
        // 使用父类加密
        SimpleHash simpleHash = new SimpleHash("MD5",password,"yuqn",3);
    }
}
