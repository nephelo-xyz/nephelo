package com.nephelo.user.service;

import org.springframework.stereotype.Service;

@FunctionalInterface
public interface UserCacheService {
    public String getUser(String id);
}
