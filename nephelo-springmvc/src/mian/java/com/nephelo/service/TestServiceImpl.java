package com.nephelo.service;


import com.nephelo.annotation.MyService;

@MyService("testService")
public class TestServiceImpl implements TestService {

    @Override
    public void doServiceTest() {
        System.out.println("业务层执行方法了。。。");
    }
}
