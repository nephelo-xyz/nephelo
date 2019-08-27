package com.nephelo.user.service;

import com.nephelo.common.service.BaseService;
import com.nephelo.user.bean.TGroup;

import java.util.List;

public interface TGroupService extends BaseService<TGroup> {

    List<TGroup> getListBygroupTypeId(Integer groupTypeId);

    String[] getCodeByUsername(String username);
}
