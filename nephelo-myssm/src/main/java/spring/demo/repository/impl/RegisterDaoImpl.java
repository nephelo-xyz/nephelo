package spring.demo.repository.impl;

import lombok.extern.log4j.Log4j2;
import spring.annotation.MyRepository;
import spring.demo.repository.RegisterDao;
import spring.demo.service.RegisterService;

/**
 * Created by nephelo on 2018/6/27.
 */
@Log4j2
@MyRepository
public class RegisterDaoImpl implements RegisterDao{

    @Override
    public void register() {
       log.info("我是RegisterDao");
    }
}
