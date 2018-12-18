package com.nephelo.user.mapper;

import com.nephelo.user.bean.TGroup;
import org.mapstruct.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface TGroupMapper extends BaseMapper<TGroup> {
    List<TGroup> getListByGroupTypeId(Integer groupTypeId);

    List<TGroup> getListByUsername(String username);
}
