package com.zou.huzhu2biz.service.impl;

import com.zou.huzhu2biz.service.CardService;
import com.zou.huzhu2common.exception.UserException;
import com.zou.huzhu2common.utils.DateUtils;
import com.zou.huzhu2common.utils.IdGen;
import com.zou.huzhu2dao.mapper.CardMapper;
import com.zou.huzhu2entity.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:35
 * Project:  huzhu
 * Description:
 **/
@Service
@Transactional
public class CardServiceImpl extends BaseServiceImpl<Card> implements CardService {

    @Autowired
    private CardMapper cardMapper;

    @Override
    public List<Card> findList() {
        return cardMapper.findList();
    }

    @Override
    public void publish(Card card){
        card.setId(IdGen.UUID());
        card.setCreateTime(DateUtils.getNow());
        cardMapper.publish(card);
    }
}
