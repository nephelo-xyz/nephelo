package com.nephelo.dhx.service.impl;

import com.nephelo.dhx.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service("UserCacheService")
public class UserCacheServiceImpl implements UserCacheService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Cacheable(value = "user", key = "#id", unless = "#result==null")
    public String getUser(String id) {
        String tUser = (String) redisTemplate.opsForValue().get(id);
        if ("".equals(tUser) || null == tUser) {
            System.out.println("i am from userService");
//            System.out.println(stringRedisTemplate.getValueSerializer());
//            System.out.println(redisTemplate.getValueSerializer());
            stringRedisTemplate.opsForValue().set("admin", "admin");
        } else {
            return tUser;
        }
        return "fee";
    }
}
