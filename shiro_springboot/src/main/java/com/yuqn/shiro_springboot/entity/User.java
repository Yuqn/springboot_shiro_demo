package com.yuqn.shiro_springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private BigInteger id;
    private String name;
    private String pwd;
    private BigInteger rid;
}
