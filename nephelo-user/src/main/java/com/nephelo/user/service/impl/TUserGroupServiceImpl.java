package com.nephelo.user.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.user.bean.TUserGroup;
import com.nephelo.user.service.TUserGroupService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.BaseMapper;

@Service("TUserGroupService")
public class TUserGroupServiceImpl extends BaseServiceImpl<BaseMapper<TUserGroup>, TUserGroup>
        implements TUserGroupService {
}
