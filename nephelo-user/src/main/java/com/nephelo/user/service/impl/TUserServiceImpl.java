package com.nephelo.user.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.user.bean.TGroup;
import com.nephelo.user.bean.TUser;
import com.nephelo.user.bean.TUserGroup;
import com.nephelo.user.constant.UserConstant;
import com.nephelo.user.mapper.TUserMapper;
import com.nephelo.user.service.TGroupService;
import com.nephelo.user.service.TUserGroupService;
import com.nephelo.user.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TUserService")
public class TUserServiceImpl extends BaseServiceImpl<TUserMapper, TUser> implements TUserService {
    @Autowired
    private TUserGroupService tUserGroupService;
    @Autowired
    private TGroupService tGroupService;

    @Override
    public TUser getByUsername(String userName) {
        return mapper.getByUsername(userName);
    }

    @Override
    public List<TUser> getByKey(String key) {
        return mapper.getByKey(key);
    }

    @Override
    public List<TUser> getLeadersByGroupId(Integer groupId) {
        return mapper.getLeadersByGroupId(groupId);
    }

    @Override
    public List<TUser> getMembersByGroupId(Integer groupId) {
        return mapper.getMembersByGroupId(groupId);
    }

    @Override
    public void register(TUser tUser) {
        //获取普通用户角色
        TGroup tGroup = new TGroup();
        tGroup.setCode(UserConstant.ROLE_USER_CODE);
        tGroup = tGroupService.selectOne(tGroup);

        //插入用户
        mapper.insert(tUser);

        //给新注册用户授权普通用户角色
        TUserGroup tUserGroup = new TUserGroup();
        tUserGroup.setUserId(tUser.getId());
        tUserGroup.setGroupId(tGroup.getId());
        tUserGroup.setType(UserConstant.USER_GROUP_TYPE_MEMBER);
        tUserGroupService.insert(tUserGroup);

    }
}
