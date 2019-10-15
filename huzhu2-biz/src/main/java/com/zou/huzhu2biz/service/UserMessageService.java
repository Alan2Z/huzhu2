package com.zou.huzhu2biz.service;

import com.zou.huzhu2entity.entity.User;
import com.zou.huzhu2entity.entity.UserMessage;

import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:39
 * Project:  huzhu
 * Description:
 **/
public interface UserMessageService extends BaseService<UserMessage> {

    List<UserMessage> findMsgList(String createUser);
}
