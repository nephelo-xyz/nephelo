package com.nephelo.user.service;

import com.nephelo.common.service.BaseService;
import com.nephelo.user.bean.TUser;

import java.util.List;

public interface TUserService extends BaseService<TUser> {
    TUser getByUsername(String userName);

    List<TUser> getByKey(String key);

    List<TUser> getLeadersByGroupId(Integer groupId);

    List<TUser> getMembersByGroupId(Integer groupId);

    void register(TUser tUser);
}
