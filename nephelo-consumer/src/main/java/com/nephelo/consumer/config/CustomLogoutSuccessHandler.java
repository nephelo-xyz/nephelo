package com.nephelo.consumer.config;


import com.alibaba.fastjson.JSON;
import com.nephelo.common.util.HttpHelper;
import com.nephelo.common.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* 简述 登出
* @author nephelo
* 2018-12-20
*/
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
      String result = JSON.toJSONString(JsonUtil.getSuccessJsonObject(true));
      logger.info("nephelo result:{}",result);
      if (authentication != null && authentication.getDetails() != null) {
          try {
              httpServletRequest.getSession().invalidate();
              httpServletResponse.setStatus(HttpServletResponse.SC_OK);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      HttpHelper.setResponseJsonData(httpServletResponse,result);
    }
}