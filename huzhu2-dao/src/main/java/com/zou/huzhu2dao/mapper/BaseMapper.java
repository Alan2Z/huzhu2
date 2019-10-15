package com.zou.huzhu2dao.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:25
 * Project:  huzhu
 * Description:
 **/
@Repository
public interface BaseMapper<T> {

    T findById(T t);

    List<T> findAll();


}
