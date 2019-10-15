package com.zou.huzhu2dao.mapper;

import com.zou.huzhu2entity.entity.MessageLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/9/8 15:42
 * Project:  huzhu2
 * Description:
 **/
@Repository
public interface MessageLogMapper extends BaseMapper<MessageLog> {

    void insert(MessageLog messageLog);

    void updateStatus(@Param("messageId") String messageId, @Param("status") String status, @Param("updateTime")LocalDateTime updateTime);

    void retry(MessageLog messageLog);

    List<MessageLog> findStatus0AndTimeOutMessage();
}
