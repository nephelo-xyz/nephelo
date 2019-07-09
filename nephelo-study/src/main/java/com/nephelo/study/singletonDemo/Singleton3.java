package com.nephelo.study.singletonDemo;

/**
 * 1.私有构造方法
 * 2.公有的 静态的 get实例方法
 * 3.静态的实例变量
 */
public class Singleton3 {
    //懒汉式增强 双重检测
    private static Singleton3 singleton;

    private Singleton3() {
    }

    //线程安全 只在创建的时候加锁 只要singleton不为空则不存在并发安全问题
    public static Singleton3 getInstance() {
        if (null == singleton) {
            Singleton3 sc;
            synchronized (Singleton3.class) {
                sc = singleton;
                if (sc == null) {
                    synchronized (Singleton3.class) {
                        sc = new Singleton3();
                    }
                }
                singleton = sc;
            }
        }
        return singleton;
    }

    //一个同步写法
    public static Singleton3 getInstance1() {
        if (null == singleton) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
