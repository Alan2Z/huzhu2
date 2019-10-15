package com.zou.huzhu2entity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 15:15
 * Project:  huzhu
 * Description: 用户消息
 **/
@Data
public class UserMessage implements Serializable {

    private String id;
    //发送人
    private String sendId;
    private String sendName;
    private String sendHead;
    //接收人
    private String addressId;
    private String addressName;
    private String addressHead;
    private String content;
    private Integer type;
    private String createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private Integer isRead;

    //虚拟属性
    private int msgNum;//消息条数
    private String lastMsg;//最后一条消息

}
