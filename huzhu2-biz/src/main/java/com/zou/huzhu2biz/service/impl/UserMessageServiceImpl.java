package com.zou.huzhu2biz.service.impl;

import com.zou.huzhu2biz.service.UserMessageService;
import com.zou.huzhu2dao.mapper.UserMessageMapper;
import com.zou.huzhu2entity.entity.User;
import com.zou.huzhu2entity.entity.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:39
 * Project:  huzhu
 * Description:
 **/
@Service
@Transactional
public class UserMessageServiceImpl extends BaseServiceImpl<UserMessage> implements UserMessageService {

    @Autowired
    private UserMessageMapper userMessageMapper;

    @Override
    public List<UserMessage> findMsgList(String createUser) {
        List<UserMessage> list = userMessageMapper.findMsgList(createUser);
        list.forEach(msg ->{
            UserMessage lastMsg = userMessageMapper.findLastMsg(msg.getSendId(), createUser);
            msg.setLastMsg(lastMsg.getContent());
            msg.setCreateTime(lastMsg.getCreateTime());
        });
        return list;
    }
}
