package spring.demo.repository.impl;

import spring.annotation.MyRepository;
import spring.demo.repository.UserDao;

/**
 * Created by nephelo on 2018/6/27.
 */
@MyRepository
public class UserDaoImpl implements UserDao {

    @Override
    public void test() {
       log.info("我是UserDao");
    }
}
