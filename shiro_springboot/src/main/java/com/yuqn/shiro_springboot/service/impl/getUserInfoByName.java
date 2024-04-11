package com.yuqn.shiro_springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuqn.shiro_springboot.entity.User;
import com.yuqn.shiro_springboot.mapper.UserMapper;
import com.yuqn.shiro_springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class getUserInfoByName implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserInfoByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println("user = " + user);
        return user;
    }
}
