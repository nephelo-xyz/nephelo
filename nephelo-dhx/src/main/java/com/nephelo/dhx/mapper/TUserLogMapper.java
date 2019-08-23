package com.nephelo.dhx.mapper;

import com.nephelo.dhx.bean.TUserLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TUserLogMapper extends Mapper<TUserLog> {
    List<TUserLog> listByPageNewRecord();
}