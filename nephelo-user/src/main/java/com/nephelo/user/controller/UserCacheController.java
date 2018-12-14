package com.nephelo.user.controller;

import com.nephelo.user.bean.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserCacheController {
    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @GetMapping(value = "/cache/user/cacheUser")
    @ResponseBody
    public Map<String, Object> cacheUser() {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", "000000");
        result.put("msg", "success");
        TUser u = new TUser();

        u.setObjectId("38a8b5cc767b48768d91e584c0243243");
        u.setUsername("admin");
        u.setPassword("admin");
        result.put("data", u);
        redisCacheTemplate.opsForValue().set(String.valueOf(u.getObjectId()), u);
        return result;
    }
}
