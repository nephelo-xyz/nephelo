package com.nephelo.user.mapper;

import com.nephelo.user.bean.TElement;
import org.mapstruct.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface TElementMapper extends BaseMapper<TElement> {
    List<TElement> getListByMenuId(Integer menuId);

    List<TElement> getAuthorityElementsByUsername(String username);

    List<TElement> getListByRole(String role);
}