package com.nephelo.dhx.mapper;

import com.nephelo.dhx.bean.TMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TMenuMapper extends Mapper<TMenu> {
    List<TMenu> getAuthorityMenusByUsername(String username);
}