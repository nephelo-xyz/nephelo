package com.nephelo.dhx.service;

import com.nephelo.common.service.BaseService;
import com.nephelo.dhx.bean.TMenu;

import java.util.List;

public interface TMenuService extends BaseService<TMenu> {

    List<TMenu> getAuthorityMenusByUsername(String username);
}
