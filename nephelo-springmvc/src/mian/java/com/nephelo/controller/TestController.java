package com.nephelo.controller;

import com.nephelo.annotation.MyController;
import com.nephelo.annotation.MyQualifier;
import com.nephelo.annotation.MyRequestMapping;
import com.nephelo.annotation.MyRequestParam;
import com.nephelo.service.TestService;
import com.nephelo.service.TestService2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MyController
@MyRequestMapping("/test")
public class TestController {

    @MyQualifier("testService")
    private TestService testService;
    // 测试@MyService使用默认值
    @MyQualifier("testService2Impl")
    private TestService2 testService2;

    /**
     * 测试的url：http://localhost:8080/dh-springmvc/test/1?str_param=233&int_param=2&float_param=1.2&double_param=2.5
     *
     * @param request
     * @param response
     * @param strParam
     * @param intParam
     * @param floatParam
     * @param doubleParam
     */
    @MyRequestMapping("/1")
    public void test1(HttpServletRequest request, HttpServletResponse response,
                      @MyRequestParam("str_param") String strParam,
                      @MyRequestParam("int_param") Integer intParam,
                      @MyRequestParam("float_param") Float floatParam,
                      @MyRequestParam("double_param") Double doubleParam) {
        testService.doServiceTest();
        testService2.doServiceTest();
        try {
            response.getWriter().write(
                    "String parameter: " + strParam +
                            "\nInteger parameter: " + intParam +
                            "\nFloat parameter: " + floatParam +
                            "\nDouble parameter: " + doubleParam);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
