package spring.test;

import lombok.extern.log4j.Log4j2;

/**
 * @ClassName UserDaoProxy
 * @Description
 * @Data 2018/7/7
 * @Author nephelo
 */
@Log4j2
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao iUserDao){
        this.target = iUserDao;
    }

    @Override
    public void save() {
       log.info("开启事务");
        target.save();
       log.info("关闭事务");
    }

}
