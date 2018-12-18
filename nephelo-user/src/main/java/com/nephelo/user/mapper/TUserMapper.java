package com.nephelo.user.mapper;

import com.nephelo.user.bean.TUser;
import org.mapstruct.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface TUserMapper extends BaseMapper<TUser> {
    TUser getByUsername(String userName);

    List<TUser> getByKey(String key);

    List<TUser> getLeadersByGroupId(Integer groupId);

    List<TUser> getMembersByGroupId(Integer groupId);
}
