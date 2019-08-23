package com.nephelo.dhx.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.dhx.bean.TDict;
import com.nephelo.dhx.mapper.TDictMapper;
import com.nephelo.dhx.service.TDictService;
import org.springframework.stereotype.Service;

@Service("TDictService")
public class TDictServiceImpl extends BaseServiceImpl<TDictMapper, TDict> implements TDictService {
}
