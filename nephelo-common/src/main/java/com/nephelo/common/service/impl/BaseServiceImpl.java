package com.nephelo.common.service.impl;

import com.nephelo.common.service.BaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.BaseMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T> {
    @Resource
    protected M mapper;

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }

    public List<T> selectListAll() {
        return mapper.selectAll();
    }

    public Long selectCount(T entity) {
        return Long.valueOf(mapper.selectCount(entity));
    }

    public void insert(T entity) {
        mapper.insert(entity);
    }

    public int insertSelective(T entity) {
        return mapper.insertSelective(entity);
    }

    public int delete(T entity) {
        return mapper.delete(entity);
    }

    public int deleteById(Object id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int updateById(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateSelectiveById(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

}
