package com.nephelo.user.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.user.bean.TDict;
import com.nephelo.user.mapper.TDictMapper;
import com.nephelo.user.service.TDictService;
import org.springframework.stereotype.Service;

@Service("TDictService")
public class TDictServiceImpl extends BaseServiceImpl<TDictMapper, TDict> implements TDictService {
}
