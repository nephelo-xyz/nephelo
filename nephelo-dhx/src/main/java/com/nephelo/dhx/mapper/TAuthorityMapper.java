package com.nephelo.dhx.mapper;

import com.nephelo.dhx.bean.TAuthority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TAuthorityMapper extends Mapper<TAuthority> {
    void deleteByGroupId(Integer groupId);

    List<TAuthority> getListByAuthorityId(Integer authorityId);
}