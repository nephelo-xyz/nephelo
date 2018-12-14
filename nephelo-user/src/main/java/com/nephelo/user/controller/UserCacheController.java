package com.nephelo.user.controller;

import com.nephelo.user.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCacheController {
    @Autowired
    UserCacheService userCacheService;

    @GetMapping(value = "getUser", params = "id")
    @ResponseBody
    public String getUser() {
        return userCacheService.getUser("id");
    }
}
