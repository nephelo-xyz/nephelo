package com.nephelo.user.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.user.bean.TGroup;
import com.nephelo.user.mapper.TGroupMapper;
import com.nephelo.user.service.TGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TGroupService")
public class TGroupServiceImpl extends BaseServiceImpl<TGroupMapper, TGroup> implements TGroupService {
    @Override
    public List<TGroup> getListBygroupTypeId(Integer groupTypeId) {
        return null;
    }

    @Override
    public String[] getCodeByUsername(String username) {
        return new String[0];
    }
}
