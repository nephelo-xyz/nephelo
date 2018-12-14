package com.nephelo.user.service;

import org.springframework.stereotype.Service;

@Service
public interface UserCacheService {
    public String getUser(String id);
}
