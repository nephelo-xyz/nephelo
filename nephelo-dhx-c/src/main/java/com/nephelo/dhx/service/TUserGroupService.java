package com.nephelo.dhx.service;

import com.alibaba.fastjson.JSONObject;
import com.nephelo.common.service.BaseService;
import com.nephelo.dhx.bean.TUserGroup;

public interface TUserGroupService extends BaseService<TUserGroup> {

    Boolean saveGroupRelateUsers(Integer groupId, JSONObject param);

    Boolean addByUserIdAndGroupId(TUserGroup tUserGroup);

    Boolean deleteByUserIdAndGroupId(TUserGroup tUserGroup);
}