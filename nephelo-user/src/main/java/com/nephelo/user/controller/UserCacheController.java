package com.nephelo.user.controller;

import com.nephelo.user.service.UserCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserCacheController {
    @Resource
    UserCacheService userCacheService;

    @GetMapping(value = "getUser", params = "id")
    @ResponseBody
    public String getUser(String id) {
        return userCacheService.getUser(id);
    }

    @PostMapping(value = "login")
    @ResponseBody
    public String login(String username, String password) {
        return userCacheService.getUser(username);
    }
}
