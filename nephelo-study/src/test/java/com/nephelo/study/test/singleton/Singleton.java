package com.nephelo.study.test.singleton;

import com.nephelo.study.singletonDemo.Singleton1;
import com.nephelo.study.singletonDemo.Singleton2;
import com.nephelo.study.singletonDemo.Singleton5;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Singleton {

    @Test
    public void testSingeton1() {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();
        System.out.println(singleton1 == singleton2);

        Singleton5 singleton5 = Singleton5.INSTANCE;
        Singleton5 singleton6 = Singleton5.INSTANCE;
        System.out.println(singleton5 == singleton6);
    }

    /**
     * 测试其他单例模式的反射和反序列化破解
     */
    @Test
    public void testSingeton2() throws Exception {
        Singleton2 singleton1 = Singleton2.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton1 == singleton2);

        //通过反射
        Class<Singleton2> clazz = (Class<Singleton2>) Class.forName("com.nephelo.study.singletonDemo.Singleton2");
        Constructor<Singleton2> c = clazz.getDeclaredConstructor();
        c.setAccessible(true);
        Singleton2 singleton3 = c.newInstance();
        Singleton2 singleton4 = c.newInstance();
        System.out.println(singleton3 == singleton4);

        //通过反序列化
        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singleton1);
        oos.close();
        fos.close();

        File file = new File("a.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton2 singleton5 = (Singleton2) ois.readObject();
        System.out.println(singleton1 == singleton5);
    }
}
