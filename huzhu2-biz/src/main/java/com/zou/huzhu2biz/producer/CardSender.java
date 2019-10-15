package com.zou.huzhu2biz.producer;

import com.zou.huzhu2common.utils.DateUtils;
import com.zou.huzhu2common.utils.GParameter;
import com.zou.huzhu2dao.mapper.MessageLogMapper;
import com.zou.huzhu2entity.entity.Card;
import com.zou.huzhu2entity.entity.MessageLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/9/8 14:13
 * Project:  huzhu2
 * Description: Card类的消息生产者
 **/
@Component
public class CardSender {

    private final Logger logger = LoggerFactory.getLogger(CardSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MessageLogMapper messageLogMapper;

    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            if (ack){
                messageLogMapper.updateStatus(correlationData.getId(), GParameter.CARD_SEND_SUCCESS, DateUtils.getNow());
            }else{
                logger.debug("消息{}投递失败",correlationData.getId());
                System.out.println("原因->"+cause);
            }
        }
    };

    public void send(Card card) throws Exception{
        rabbitTemplate.setConfirmCallback(confirmCallback);
        CorrelationData correlationData = new CorrelationData(card.getMessageId());
        rabbitTemplate.convertAndSend("card-exchange","card.abcd",card,correlationData);
        logger.debug("消息{}已发送",card.getMessageId());
    }

}
