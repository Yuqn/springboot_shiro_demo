package com.yuqn.shiro_springboot.service;

import com.yuqn.shiro_springboot.entity.User;

public interface UserService {
    // 用户登录
    User getUserInfoByName(String name);
}
