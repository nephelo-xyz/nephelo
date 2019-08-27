package com.nephelo.dhx.mapper;

import com.nephelo.dhx.bean.TUserGroup;
import tk.mybatis.mapper.common.Mapper;

public interface TUserGroupMapper extends Mapper<TUserGroup> {

    void deleteByGroupId(Integer groupId);

    TUserGroup getByUserIdAndGroupId(TUserGroup tUserGroup);

    Boolean deleteByUserIdAndGroupId(TUserGroup tUserGroup);
}