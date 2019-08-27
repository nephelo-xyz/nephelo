package com.nephelo.dhx.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.dhx.bean.TUserLog;
import com.nephelo.dhx.mapper.TUserLogMapper;
import com.nephelo.dhx.service.TUserLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TUserLogService")
public class TUserLogServiceImpl extends BaseServiceImpl<TUserLogMapper,TUserLog>
        implements TUserLogService {
    @Override
    public List<TUserLog> listByPageNewRecord() {
        return mapper.listByPageNewRecord();
    }
}
