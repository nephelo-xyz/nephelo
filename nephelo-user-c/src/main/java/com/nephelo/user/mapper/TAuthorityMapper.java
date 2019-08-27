package com.nephelo.user.mapper;

import com.nephelo.user.bean.TAuthority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TAuthorityMapper extends Mapper<TAuthority> {
    void deleteByGroupId(Integer groupId);

    List<TAuthority> getListByAuthorityId(Integer authorityId);
}