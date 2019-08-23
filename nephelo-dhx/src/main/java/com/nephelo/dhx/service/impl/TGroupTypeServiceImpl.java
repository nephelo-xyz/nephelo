package com.nephelo.dhx.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.dhx.bean.TGroupType;
import com.nephelo.dhx.mapper.TGroupTypeMapper;
import com.nephelo.dhx.service.TGroupTypeService;
import org.springframework.stereotype.Service;

@Service("TGroupTypeService")
public class TGroupTypeServiceImpl extends BaseServiceImpl<TGroupTypeMapper, TGroupType>
        implements TGroupTypeService {

}
