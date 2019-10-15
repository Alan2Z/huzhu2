package com.zou.huzhu2web.controller;

import com.alibaba.fastjson.JSON;
import com.zou.huzhu2biz.producer.CardSender;
import com.zou.huzhu2biz.service.CardService;
import com.zou.huzhu2biz.service.MessageLogService;
import com.zou.huzhu2common.utils.DateUtils;
import com.zou.huzhu2common.utils.ErrorCode;
import com.zou.huzhu2common.utils.GParameter;
import com.zou.huzhu2common.utils.Response;
import com.zou.huzhu2entity.entity.Card;
import com.zou.huzhu2entity.entity.MessageLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 22:20
 * Project:  huzhu
 * Description:
 **/
@RestController
@RequestMapping("card")
public class CardController {

    @Autowired
    private CardService cardService;
    @Autowired
    private CardSender cardSender;
    @Autowired
    private MessageLogService messageLogService;

    @PostMapping("list")
    public Response getList(){
        List<Card> list = cardService.findList();
        return Response.success(list);
    }

    @PostMapping("publish")
    public Response publishCard(@RequestBody Card card) throws Exception {
        if (StringUtils.isBlank(card.getCardContent())){
            return Response.error(ErrorCode.SYSTEM_ERROR);
        }
        card.setMessageId(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString());
        //卡片入库
        cardService.publish(card);
        //消息记录入库
        MessageLog messageLog = new MessageLog();
        messageLog.setMessageId(card.getMessageId());
        messageLog.setMessage(JSON.toJSONString(card));
        messageLog.setStatus(GParameter.CARD_MESSAGE_SENDING);
        messageLog.setNextRetry(DateUtils.addSeconds(DateUtils.getNow(),60));
        messageLog.setCreateTime(DateUtils.getNow());
        messageLogService.insert(messageLog);
        //发送消息
        cardSender.send(card);
        return Response.success();
    }
}
