package com.zou.huzhu2dao.mapper;

import com.zou.huzhu2entity.entity.Card;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:30
 * Project:  huzhu
 * Description:
 **/
@Repository
public interface CardMapper extends BaseMapper<Card> {


    List<Card> findList();


    void publish(Card card);
}
