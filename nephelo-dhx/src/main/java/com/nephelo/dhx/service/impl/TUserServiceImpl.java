package com.nephelo.dhx.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.dhx.constant.UserConstant;
import com.nephelo.dhx.bean.TGroup;
import com.nephelo.dhx.bean.TUser;
import com.nephelo.dhx.bean.TUserGroup;
import com.nephelo.dhx.mapper.TUserMapper;
import com.nephelo.dhx.service.TGroupService;
import com.nephelo.dhx.service.TUserGroupService;
import com.nephelo.dhx.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserServiceImpl extends BaseServiceImpl<TUserMapper,TUser> implements TUserService{

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
