package com.nephelo.dhx.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.dhx.bean.TGroup;
import com.nephelo.dhx.mapper.TGroupMapper;
import com.nephelo.dhx.service.TGroupService;
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
