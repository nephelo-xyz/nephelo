package com.nephelo.user.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.user.bean.TUserLog;
import com.nephelo.user.mapper.TUserLogMapper;
import com.nephelo.user.service.TUserLogService;
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
