package com.nephelo.study.singletonDemo;

import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

/**
 * 1.私有构造方法
 * 2.公有的 静态的 get实例方法
 * 3.静态的实例变量
 */
@Log4j2
public class Singleton2 implements Serializable {
    //懒汉式
    private static Singleton2 singleton;

    private Singleton2() {
        if (singleton != null){
           log.info("反射破解了");
        }
    }

    //线程安全
    //but 使用了同步，所以并发效率低下，一次性只能一个线程使用，后面线程只能等待
    public synchronized static Singleton2 getInstance() {
        if (null == singleton) {
            singleton = new Singleton2();
        }
        return singleton;
    }

    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
    public Object readResolve() {
        return singleton;
    }
}
