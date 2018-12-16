package com.nephelo.user.mapper;

import com.nephelo.user.bean.TUserLog;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TUserLogMapper extends Mapper<TUserLog> {
    List<TUserLog> listByPageNewRecord();
}