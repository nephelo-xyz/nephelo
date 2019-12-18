package spring.test;

import lombok.extern.log4j.Log4j2;

/**
 * @ClassName TestUserDao
 * @Description
 * @Data 2018/7/7
 * @Author nephelo
 */
@Log4j2
public class TestUserDao implements IUserDao {

    @Override
    public void save() {
       log.info("已经保存数据...");
    }


    public static void main(String[] args) {
        UserDaoProxy userDaoProxy = new UserDaoProxy(new TestUserDao());
        userDaoProxy.save();
    }


}
