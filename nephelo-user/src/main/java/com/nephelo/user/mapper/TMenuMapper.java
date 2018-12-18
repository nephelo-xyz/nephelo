package com.nephelo.user.mapper;

import com.nephelo.user.bean.TMenu;
import org.mapstruct.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface TMenuMapper extends BaseMapper<TMenu> {
    List<TMenu> getAuthorityMenusByUsername(String username);
}