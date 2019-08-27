package com.nephelo.user.service.impl;

import com.nephelo.common.service.impl.BaseServiceImpl;
import com.nephelo.user.bean.TElement;
import com.nephelo.user.mapper.TElementMapper;
import com.nephelo.user.po.TElementVo;
import com.nephelo.user.service.TElementService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("TElementService")
public class TElementServiceImpl extends BaseServiceImpl<TElementMapper, TElement> implements TElementService {

    @Override
    public List<TElement> getListByMenuId(Integer menuId) {
        return mapper.getListByMenuId(menuId);
    }

    @Override
    public List<TElement> getAuthorityElementsByUsername(String username) {
        return mapper.getAuthorityElementsByUsername(username);
    }

    /*@Cacheable(value = "telement_role", key = "'role_element_'+#role")*/
    public List<TElementVo> getListByRole(String role) {
        List<TElementVo> resultList = new ArrayList<>();
        List<TElement> tElements = mapper.getListByRole(role);
        tElements.forEach(tElement -> {
            TElementVo tElementVo = new TElementVo();
            BeanUtils.copyProperties(tElement, tElementVo);
            resultList.add(tElementVo);
        });
        return resultList;
    }

    @Override
    public String[] getPermissionsByRoles(String[] roles) {
        Set<TElementVo> tElementSet = new HashSet<>();
        for (int i = 0; i < roles.length; i++) {
            String role = roles[i];
            List<TElementVo> tElements = getListByRole(role);
            tElementSet.addAll(tElements);
        }

        Set<String> permissions = new HashSet<>();
        for (TElementVo tElement : tElementSet) {
            if (StringUtils.isNotEmpty(tElement.getCode())) {
                String permission = tElement.getCode();
                permissions.add(permission);
            }
        }
        return permissions.toArray(new String[permissions.size()]);
    }
}
