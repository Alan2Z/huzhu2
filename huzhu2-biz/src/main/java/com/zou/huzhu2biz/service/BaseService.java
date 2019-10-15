package com.zou.huzhu2biz.service;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:21
 * Project:  huzhu
 * Description:
 **/
public interface BaseService<T> {

    T findById(T t);

    List<T> findAll();



}
