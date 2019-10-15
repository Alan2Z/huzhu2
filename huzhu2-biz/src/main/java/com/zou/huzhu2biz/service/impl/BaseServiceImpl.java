package com.zou.huzhu2biz.service.impl;

import com.zou.huzhu2dao.mapper.BaseMapper;
import com.zou.huzhu2biz.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:25
 * Project:  huzhu
 * Description:
 **/
@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper baseMapper;


    @Override
    public T findById(T t) {
        return (T) baseMapper.findById(t);
    }

    @Override
    public List<T> findAll() {
        return baseMapper.findAll();
    }
}
