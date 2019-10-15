package com.zou.huzhu2biz.service;

import com.zou.huzhu2entity.entity.Card;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:34
 * Project:  huzhu
 * Description:
 **/
public interface CardService extends BaseService<Card> {

    List<Card> findList();

    void publish(Card card);
}
