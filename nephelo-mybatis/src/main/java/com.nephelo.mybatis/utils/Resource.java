package com.nephelo.mybatis.utils;

import java.io.InputStream;

public class Resource {

    public static final String PATH_PREFIX = "classpath:";
    public static final String ROOT_PREFIX = "/";
    //获取系统类加载器
    private static ClassLoader loader = ClassLoader.getSystemClassLoader();

    public static InputStream getResource(String location) {
        return loader.getResourceAsStream(handlePath(location));
    }

    private static String handlePath(String location) {
        if (location.startsWith(PATH_PREFIX)) {
            return location.substring(PATH_PREFIX.length());
        } else if (location.startsWith(ROOT_PREFIX)) {
            return location.substring(ROOT_PREFIX.length());
        } else {
            return location;
        }
    }
}
