package com.yuqn.shiro_springboot;

import com.yuqn.shiro_springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
        System.out.println("userService.getUserInfoByName(\"yuqn\") = " + userService.getUserInfoByName("yuqn"));
    }
}
