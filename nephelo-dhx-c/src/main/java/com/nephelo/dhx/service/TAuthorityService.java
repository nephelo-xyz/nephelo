package com.nephelo.dhx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nephelo.common.service.BaseService;
import com.nephelo.dhx.bean.TAuthority;

public interface TAuthorityService extends BaseService<TAuthority> {

    boolean saveBatch(Integer groupId, JSONArray menuIds, JSONArray elementIds);

    JSONObject getAuthority(Integer groupId);
}
