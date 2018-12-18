package com.nephelo.user.mapper;

import com.nephelo.user.bean.TAuthority;
import org.mapstruct.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface TAuthorityMapper extends BaseMapper<TAuthority> {
    void deleteByGroupId(Integer groupId);

    List<TAuthority> getListByAuthorityId(Integer authorityId);
}