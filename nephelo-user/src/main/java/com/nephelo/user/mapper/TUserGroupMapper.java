package com.nephelo.user.mapper;

import com.nephelo.user.bean.TUserGroup;
import org.mapstruct.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface TUserGroupMapper extends BaseMapper<TUserGroup> {

    void deleteByGroupId(Integer groupId);

    TUserGroup getByUserIdAndGroupId(TUserGroup tUserGroup);

    Boolean deleteByUserIdAndGroupId(TUserGroup tUserGroup);
}