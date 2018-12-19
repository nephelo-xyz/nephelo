package com.nephelo.user.service;

import com.nephelo.common.service.BaseService;
import com.nephelo.user.bean.TElement;
import com.nephelo.user.po.TElementVo;

import java.util.List;

public interface TElementService extends BaseService<TElement> {

    List<TElement> getListByMenuId(Integer menuId);

    List<TElement> getAuthorityElementsByUsername(String username);

    List<TElementVo> getListByRole(String role);

    String[] getPermissionsByRoles(String[] roles);
}
