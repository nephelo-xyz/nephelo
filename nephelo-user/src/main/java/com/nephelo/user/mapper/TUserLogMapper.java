package com.nephelo.user.mapper;

import com.nephelo.user.bean.TUserLog;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
public interface TUserLogMapper extends BaseMapper<TUserLog> {
    List<TUserLog> listByPageNewRecord();
}