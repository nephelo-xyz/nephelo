package com.nephelo.user.mapper;

import com.nephelo.user.bean.TUserLog;
import org.mapstruct.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface TUserLogMapper extends BaseMapper<TUserLog> {
    List<TUserLog> listByPageNewRecord();
}