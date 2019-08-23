package com.nephelo.dhx.controller;

import com.alibaba.fastjson.JSONObject;
import com.nephelo.api.vo.authority.SessionInfo;
import com.nephelo.common.util.JsonUtil;
import com.nephelo.dhx.feign.TUserServiceFeign;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("v1/session")
public class SessionController extends TUserServiceFeign {
    private Logger logger = LoggerFactory.getLogger(SessionController.class);
    @Autowired
    protected HttpServletRequest request;
    /**
     * 测试从session中获取用户信息
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "获取session中的信息" )
    @RequestMapping(value = "sessionInfo", method = RequestMethod.GET)
    public JSONObject sessionUserInfo()throws Exception{
        try {
            SessionInfo sessionInfo  = (SessionInfo) request.getSession().getAttribute("sessionInfo");
            logger.info("nephelo:sessionInfo:{}",sessionInfo);
            return JsonUtil.getSuccessJsonObject(sessionInfo);
        }catch ( Exception e){
            e.printStackTrace();
        }
        return JsonUtil.getFailJsonObject();
    }

}
