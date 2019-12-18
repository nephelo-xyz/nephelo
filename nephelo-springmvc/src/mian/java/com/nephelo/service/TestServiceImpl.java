package com.nephelo.service;


import com.nephelo.annotation.MyService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@MyService("testService")
public class TestServiceImpl implements TestService {

    @Override
    public void doServiceTest() {
       log.info("业务层执行方法了。。。");
    }
}
