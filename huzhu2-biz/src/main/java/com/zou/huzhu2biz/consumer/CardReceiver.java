package com.zou.huzhu2biz.consumer;

import com.rabbitmq.client.Channel;
import com.zou.huzhu2biz.service.CardService;
import com.zou.huzhu2entity.entity.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/9/8 14:47
 * Project:  huzhu2
 * Description: Card类的消息消费者
 **/
@Component
public class CardReceiver {

    private final Logger logger = LoggerFactory.getLogger(CardReceiver.class);

    @Autowired
    private CardService cardService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "card-queue",durable = "true"),
            exchange = @Exchange(name = "card-exchange",durable = "true",type = "topic"),
            key = "card.*"
        )
    )
    @RabbitHandler
    public void onCardMessage(@Payload Card card, @Headers Map<String,Object> headers, Channel channel) throws Exception{
        logger.debug("消费者接收到消息{} 开始处理",card.getMessageId());
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//        cardService.publish(card);
        channel.basicAck(deliveryTag,false);
        logger.debug("消费者处理完成 {}",card.getMessageId());
    }

}
