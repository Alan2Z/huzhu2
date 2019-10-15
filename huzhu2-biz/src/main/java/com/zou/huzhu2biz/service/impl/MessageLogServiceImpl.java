package com.zou.huzhu2biz.service.impl;

import com.zou.huzhu2biz.service.MessageLogService;
import com.zou.huzhu2dao.mapper.MessageLogMapper;
import com.zou.huzhu2entity.entity.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/9/8 16:13
 * Project:  huzhu2
 * Description:
 **/
@Service
@Transactional
public class MessageLogServiceImpl extends BaseServiceImpl<MessageLog> implements MessageLogService {

    @Autowired
    private MessageLogMapper messageLogMapper;

    @Override
    public void insert(MessageLog messageLog) {
        messageLogMapper.insert(messageLog);
    }

    @Override
    public void updateStatus(String messageId, String status, LocalDateTime updateTime) {
        messageLogMapper.updateStatus(messageId,status,updateTime);
    }

    @Override
    public void retry(MessageLog messageLog) {
        messageLogMapper.retry(messageLog);
    }
}
