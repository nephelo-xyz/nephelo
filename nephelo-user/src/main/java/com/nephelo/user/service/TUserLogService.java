package com.nephelo.user.service;

import com.nephelo.common.service.BaseService;
import com.nephelo.user.bean.TUserLog;

import java.util.List;

public interface TUserLogService extends BaseService<TUserLog> {
    List<TUserLog> listByPageNewRecord();
}
