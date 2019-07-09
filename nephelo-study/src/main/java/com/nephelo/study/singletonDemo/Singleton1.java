package com.nephelo.study.singletonDemo;

/**
 *
 * 1.私有构造方法
 * 2.公有的 静态的 get实例方法
 * 3.静态的实例变量
 */
public class Singleton1 {
    //饿汉式
    private static Singleton1 singleton = new Singleton1();
    private Singleton1() {}
    public static Singleton1 getInstance() {
        return singleton;
    }
}
