package com.nephelo.dhx.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.dhx.bean.TMenu;
import com.nephelo.dhx.mapper.TMenuMapper;
import com.nephelo.dhx.service.TMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TMenuService")
public class TMenuServiceImpl extends BaseServiceImpl<TMenuMapper, TMenu> implements TMenuService {

    @Override
    public List<TMenu> getAuthorityMenusByUsername(String username) {
        return mapper.getAuthorityMenusByUsername(username);
    }
}
