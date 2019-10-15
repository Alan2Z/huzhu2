package com.zou.huzhu2biz.service;

import com.zou.huzhu2entity.entity.MessageLog;

import java.time.LocalDateTime;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/9/8 16:12
 * Project:  huzhu2
 * Description:
 **/
public interface MessageLogService extends BaseService<MessageLog> {

    void insert(MessageLog messageLog);

    void updateStatus(String messageId,String status,LocalDateTime updateTime);

    void retry(MessageLog messageLog);
}
