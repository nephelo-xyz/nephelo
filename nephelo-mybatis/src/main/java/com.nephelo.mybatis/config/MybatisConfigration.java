package com.nephelo.mybatis.config;

import com.nephelo.mybatis.utils.Resource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 解析xml文件  DataSource和 mappers的配置
 */
public class MybatisConfigration {

    public static final String DATASOURCE_ELEMENT = "dataSource";
    public static final String MAPPERS_ELEMENT = "mappers";

    private Connection configration(String configration) {
        Connection connection = null;
        InputStream inputStream = Resource.getResource(configration);
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element rootElement = document.getRootElement();
            connection = parseElement(rootElement).getConnection();
        } catch (Exception e) {
            e.getMessage();
        }
        return connection;
    }

    private Configuration parseElement(Element element) {
        Configuration configuration = null;
        List<Element> elements = element.elements();
        elements.forEach(el -> {
            if (DATASOURCE_ELEMENT.equals(el.getName())) {
                //解析DataSource
                List<Element> list = el.elements();
                AtomicReference<String> url = null;
                AtomicReference<String> username = null;
                AtomicReference<String> password = null;
                AtomicReference<String> driver = null;
                list.forEach(pro -> {
                    String proName = pro.attributeValue("name");
                    String proValue = pro.attributeValue("value");
                    switch (proName) {
                        case "url":
                            url.set(proValue);
                        case "username":
                            username.set(proValue);
                        case "password":
                            password.set(proValue);
                        case "driver":
                            driver.set(proValue);
                    }
                });
                try {
                    //加载驱动
                    Class.forName(driver.get());
                    //获取连接
                    Connection connection = DriverManager.getConnection(url.get(), username.get(), password.get());
                    configuration.setConnection(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (MAPPERS_ELEMENT.equals(el.getName())) {

            }
        });
        return null;
    }
}
