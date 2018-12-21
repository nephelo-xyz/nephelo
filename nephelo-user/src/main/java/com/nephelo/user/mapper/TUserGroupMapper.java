package com.nephelo.user.mapper;

import com.nephelo.user.bean.TUserGroup;
import tk.mybatis.mapper.common.Mapper;

public interface TUserGroupMapper extends Mapper<TUserGroup> {

    void deleteByGroupId(Integer groupId);

    TUserGroup getByUserIdAndGroupId(TUserGroup tUserGroup);

    Boolean deleteByUserIdAndGroupId(TUserGroup tUserGroup);
}