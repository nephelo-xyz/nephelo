package com.nephelo.mybatis.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class User {
    private String username;
    private int age;
    private Date birthday;
}
