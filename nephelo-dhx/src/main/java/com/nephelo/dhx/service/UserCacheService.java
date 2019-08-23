package com.nephelo.dhx.service;

import org.springframework.stereotype.Service;

@FunctionalInterface
public interface UserCacheService {
    public String getUser(String id);
}
