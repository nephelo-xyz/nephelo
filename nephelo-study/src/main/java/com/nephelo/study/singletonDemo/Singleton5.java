package com.nephelo.study.singletonDemo;

/**
 * 1.私有构造方法
 * 2.公有的 静态的 get实例方法
 * 3.静态的实例变量
 */
public enum Singleton5 {
    //枚举类 实现单例

    //缺点。没有懒加载
    //好处。简单、最安全(不会存在反射和反序列化的漏洞问题)
    INSTANCE; //这个代表实例对象

    public static Singleton5 getInstance() {
        return INSTANCE;
    }
}
