package com.zou.huzhu2biz.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zou.huzhu2biz.producer.CardSender;
import com.zou.huzhu2common.utils.DateUtils;
import com.zou.huzhu2common.utils.FastJsonUtils;
import com.zou.huzhu2common.utils.GParameter;
import com.zou.huzhu2dao.mapper.MessageLogMapper;
import com.zou.huzhu2entity.entity.Card;
import com.zou.huzhu2entity.entity.MessageLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/9/8 16:23
 * Project:  huzhu2
 * Description:定时器
 **/
@Component
public class Timer {

    private final Logger logger = LoggerFactory.getLogger(Timer.class);

    @Autowired
    private MessageLogMapper messageLogMapper;
    @Autowired
    private CardSender cardSender;

//    @Scheduled(cron = "0/10 * * * * ? ")
    public void reSend(){
        logger.debug("重新发送 定时任务已刷新");
        List<MessageLog> msgs = messageLogMapper.findStatus0AndTimeOutMessage();
        msgs.forEach(msg -> {
            if (msg.getTryCount()>=3){
                messageLogMapper.updateStatus(msg.getMessageId(), GParameter.CARD_SEND_FAILURE, DateUtils.getNow());
            }else{
                msg.setUpdateTime(DateUtils.getNow());
                messageLogMapper.retry(msg);
                Card card = FastJsonUtils.toBean(msg.getMessage(),Card.class);
                try {
                    cardSender.send(card);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.debug("消息{}重发失败",card.getMessageId());
                }
            }
        });
    }
}
