package com.nephelo.user.mapper;

import com.nephelo.user.bean.TMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TMenuMapper extends Mapper<TMenu> {
    List<TMenu> getAuthorityMenusByUsername(String username);
}