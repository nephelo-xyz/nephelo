package com.nephelo.user.service;

import com.alibaba.fastjson.JSONObject;
import com.nephelo.common.service.BaseService;
import com.nephelo.user.bean.TUserGroup;

public interface TUserGroupService extends BaseService<TUserGroup> {

    Boolean saveGroupRelateUsers(Integer groupId, JSONObject param);

    Boolean addByUserIdAndGroupId(TUserGroup tUserGroup);

    Boolean deleteByUserIdAndGroupId(TUserGroup tUserGroup);
}