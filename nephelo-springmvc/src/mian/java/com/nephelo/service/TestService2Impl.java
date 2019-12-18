package com.nephelo.service;

import com.nephelo.annotation.MyService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@MyService
public class TestService2Impl implements TestService2 {
    @Override
    public void doServiceTest() {
       log.info("业务层执行方法了2222222222222");
    }
}
