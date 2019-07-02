package com.nephelo.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class CommonUtils {
    /**
     * 解析base
     *
     * @param mvcConfig
     * @return BasePackName
     * @throws Exception
     */
    public static String getBasePackName(String mvcConfig) throws Exception {
        DocumentBuilderFactory document = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = document.newDocumentBuilder();
        InputStream inputStream = CommonUtils.class.getResourceAsStream(mvcConfig);
        Document doc = builder.parse(inputStream);

        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            if (child instanceof Element) {
                Element element = (Element) child;
//                System.out.println(element.getTagName());// context:component-scan
                String attribute = element.getAttribute("base-package");
//                System.out.println(attribute);// com.nephelo
                if (attribute != null || "".equals(attribute.trim())) {
                    return attribute.trim();
                }
            }
        }
        return null;
    }

    /**
     * 将限定名转换为路径，如com.nephelo -> com/nephelo
     *
     * @param qualifiedName
     * @return
     */
    public static String transferQualifiedToPath(String qualifiedName) throws Exception {
        if (qualifiedName == null) {
            throw new Exception("空串不可转换");
        }
        return qualifiedName.replaceAll("\\.", "/");
    }

    /**
     * 转换类名 第一个字母小写
     *
     * @param className
     * @return 类名
     */
    public static String toLowerFirstWord(String className) {
        if (!"".equals(className)) {
            char[] charArray = className.toCharArray();
            charArray[0] += 32;
            return String.valueOf(charArray);
        }
        return null;
    }
}
