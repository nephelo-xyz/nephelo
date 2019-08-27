package spring.demo.service;

import spring.dataObject.User;

/**
 * Created by nephelo on 2018/6/27.
 */
public interface UserService {

     User queryUser(String userName, String passWord);
}
