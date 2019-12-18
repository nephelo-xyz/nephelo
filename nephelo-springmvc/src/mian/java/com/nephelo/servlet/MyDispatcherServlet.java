package com.nephelo.servlet;

import com.nephelo.annotation.MyController;
import com.nephelo.annotation.MyQualifier;
import com.nephelo.annotation.MyRequestMapping;
import com.nephelo.annotation.MyRequestParam;
import com.nephelo.annotation.MyService;
import com.nephelo.utils.CommonUtils;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DispatcherServlet
 */
@Log4j2
public class MyDispatcherServlet extends HttpServlet {
    //扫描所有bean
    private List<String> beanNames = new ArrayList<>();
    //维护Controller实例
    private Map<String, Object> controllerInstanceMaps = new HashMap();
    //维护Service实例
    private Map<String, Object> serviceInstanceMaps = new HashMap();
    //维护url和Controller的对应handle
    private Map<String, Object> handleMapping = new HashMap();

    //init() 解析Controller到HandleMapping，映射url和Controller的对应
    @Override
    public void init(ServletConfig servletConfig) {
        try {
            // 1.获取web.xml中的bean路径和配置
            String mvcConfig = servletConfig.getInitParameter("contextConfigLocation")
                    .replace("*", "")
                    .replace("classpath:", "");

            String basePackName = CommonUtils.getBasePackName(mvcConfig);
            // 2.扫描base  basePackName:com.nephelo
            scanPack(basePackName);
            // 3.通过注解对象，找到每个bean，反射获取实例
            reflectBeansInstance();

            // 4.依赖注入，实现ioc机制
            doIoc();

            // 5.handlerMapping通过基部署 和 基于类的url找到相应的处理器
            initHandlerMapping();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Spring功能 扫描web.xml中配置bean路径下所有bean，实现IOC和DI
    private void scanPack(String basePackName) throws Exception {
        URL url = this.getClass().getClassLoader()
                .getResource("/" + CommonUtils.transferQualifiedToPath(basePackName));

        //读取包
        File file = new File(url.getFile());
        File[] files = file.listFiles();
        //扫描class
        for (File f : files) {
            if (f.isDirectory()) {
                // 遇到目录递归读取文件
                scanPack(basePackName + "." + file.getName());
            } else {
                // 将形如pers.hdh.controller.Xxx的类限定名字符串加入beanNames中
                beanNames.add(basePackName + "." + file.getName().replace(".class", ""));
               log.info("扫描到的类有：" + basePackName + "." + file.getName().replace(".class", ""));
            }
        }
    }

    /**
     * 反射维护实例
     */
    private void reflectBeansInstance() throws Exception {
        if (beanNames.isEmpty()) {
            return;
        }
        for (String className : beanNames) {
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(MyController.class)) {
                //controller
                Object controllerInstance = clazz.newInstance();
                MyController controllerAnnotation = clazz.getAnnotation(MyController.class);
                //获取 @MyController的value
                String controllerValue = controllerAnnotation.value();
                // 如果没有 value 则默认 首字母小写
                if ("".equals(controllerValue)) {
                    controllerValue = CommonUtils.toLowerFirstWord(clazz.getSimpleName());
                }
                controllerInstanceMaps.put(controllerValue, controllerInstance);
            } else if (clazz.isAnnotationPresent(MyService.class)) {
                Object serviceInstance = clazz.newInstance();
                MyService serviseAnnotation = clazz.getAnnotation(MyService.class);
                String serviceValue = serviseAnnotation.value();
                if ("".equals(serviceValue)) {
                    serviceValue = CommonUtils.toLowerFirstWord(clazz.getSimpleName());
                }
                serviceInstanceMaps.put(serviceValue, serviceInstance);
            }
        }
    }

    //解析Service 实现IOC
    private void doIoc() throws Exception {
        doIoc(controllerInstanceMaps);
        doIoc(serviceInstanceMaps);
    }

    private void doIoc(Map<String, Object> instanceMaps) throws Exception {
        if (instanceMaps.isEmpty()) {
            throw new Exception("没有发现可注入的实例");
        }
        for (Map.Entry<String, Object> entry : instanceMaps.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            // 遍历bean对象的字段
            for (Field field : fields) {
                if (field.isAnnotationPresent(MyQualifier.class)) {
                    // 通过bean字段对象上面的注解参数来注入实例
                    String insMapKey = field.getAnnotation(MyQualifier.class).value();
                    if (insMapKey.equals("")) {// 如果使用@MyController，@MyService没有配置value的值，默认使用类名 首字母小写
                        insMapKey = CommonUtils.toLowerFirstWord(field.getType().getSimpleName());
                    }
                    field.setAccessible(true);
                    // 注入实例
                    field.set(entry.getValue(), instanceMaps.get(insMapKey));
                }
            }
        }
    }

    /**
     * 维护handleMapping
     */
    private void initHandlerMapping() throws Exception {
        if (controllerInstanceMaps.isEmpty()) {
            throw new Exception("没有发现handler对象");
        }
        controllerInstanceMaps.forEach((insKey, instance) -> {
            // 实现注解映射请求路径，允许当controller类没有使用@DhRequestMapping注解时，
            // 可使用@MyController注解的value作为请求路径
            String classURI = "";
            if (instance.getClass().isAnnotationPresent(MyRequestMapping.class)) {
                classURI = instance.getClass().getAnnotation(MyRequestMapping.class).value();
            } else {
                classURI = instance.getClass().getAnnotation(MyController.class).value();
            }
            // 遍历controller类中每个使用@DhRquestMapping的方法，细化请求路径
            Method[] methods = instance.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MyRequestParam.class)) {
                    String methodURI = method.getAnnotation(MyRequestMapping.class).value();
                    // 存入handlerMaps
                    String url = ("/" + classURI + "/" + methodURI).replaceAll("/+", "/");
                    handleMapping.put(url, method);
                }
            }
        });
    }
    //doGet()

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //doPost()
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    /**
     * 处理业务
     *
     * @param req
     * @param resp
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (handleMapping.isEmpty()) {
            return;
        }
        String uri = req.getRequestURI();// 如：/project_name/classURI/methodURI
        String contextPath = req.getContextPath();// 如：/project_name
        String url = uri.replace(contextPath, "").replaceAll("/+", "/");

        // 获取到请求执行的方法
        Method handlerMethod = (Method) handleMapping.get(url);
        PrintWriter out = resp.getWriter();
        if (handlerMethod == null) {
            out.print("404！！！您访问的资源不存在");
            return;
        }
        // 获取方法的参数列表
        Parameter methodParameters[] = handlerMethod.getParameters();
        // 调用方法需要传递的形参
        Object paramValues[] = new Object[methodParameters.length];
        for (int i = 0; i < methodParameters.length; i++) {
            if (ServletRequest.class.isAssignableFrom(methodParameters[i].getType())) {
                paramValues[i] = req;
            } else if (ServletResponse.class.isAssignableFrom(methodParameters[i].getType())) {
                paramValues[i] = resp;
            } else {// 其它参数，目前只支持String，Integer，Float，Double
                // 参数绑定的名称，默认为方法形参名
                String bindingValue = methodParameters[i].getName();
                if (methodParameters[i].isAnnotationPresent(MyRequestParam.class)) {
                    bindingValue = methodParameters[i].getAnnotation(MyRequestParam.class).value();
                }
                // 从请求中获取参数的值
                String paramValue = req.getParameter(bindingValue);
                paramValues[i] = paramValue;
                if (paramValue != null) {
                    if (Integer.class.isAssignableFrom(methodParameters[i].getType())) {
                        paramValues[i] = Integer.parseInt(paramValue);
                    } else if (Float.class.isAssignableFrom(methodParameters[i].getType())) {
                        paramValues[i] = Float.parseFloat(paramValue);
                    } else if (Double.class.isAssignableFrom(methodParameters[i].getType())) {
                        paramValues[i] = Double.parseDouble(paramValue);
                    }
                }
            }
        }
        try {
            handlerMethod.invoke(controllerInstanceMaps.get(url), paramValues);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
