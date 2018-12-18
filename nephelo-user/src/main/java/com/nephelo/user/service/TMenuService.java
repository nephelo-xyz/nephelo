package com.nephelo.user.service;

import com.nephelo.common.service.BaseService;
import com.nephelo.user.bean.TMenu;

import java.util.List;

public interface TMenuService extends BaseService<TMenu> {

    List<TMenu> getAuthorityMenusByUsername(String username);
}
