package com.nephelo.user.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.user.bean.TGroupType;
import com.nephelo.user.mapper.TGroupTypeMapper;
import com.nephelo.user.service.TGroupTypeService;
import org.springframework.stereotype.Service;

@Service("TGroupTypeService")
public class TGroupTypeServiceImpl extends BaseServiceImpl<TGroupTypeMapper, TGroupType>
        implements TGroupTypeService {

}
