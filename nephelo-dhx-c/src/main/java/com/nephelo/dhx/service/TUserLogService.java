package com.nephelo.dhx.service;

import com.nephelo.common.service.BaseService;
import com.nephelo.dhx.bean.TUserLog;

import java.util.List;

public interface TUserLogService extends BaseService<TUserLog> {
    List<TUserLog> listByPageNewRecord();
}
