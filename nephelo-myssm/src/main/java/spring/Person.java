package spring;

import lombok.Data;

/**
 *  @Author nephelo
 */
@Data
public class Person {
    private String userName;
    private String passWord;

    public Person() {}

    public Person(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    public void test(){
       log.info("哇塞，管用了唉");
    }
}


