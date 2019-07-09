package com.nephelo.study.singletonDemo;

/**
 * 1.私有构造方法
 * 2.公有的 静态的 get实例方法
 * 3.静态的实例变量
 */
public class Singleton4 {
    //静态内部类实现单例

    //相对于之前优点
    //1. 比饿汉式 实现了懒加载
    //2. final和static 实现线程安全
    //3. 比懒汉式 实现了并发的效率 没有加锁。
    private static class innerSingleton {
        private static final Singleton4 singleton = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return innerSingleton.singleton;
    }
}
