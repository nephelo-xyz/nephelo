package spring.test;

/**
 * @ClassName UserDaoProxy
 * @Description
 * @Data 2018/7/7
 * @Author nephelo
 */
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
