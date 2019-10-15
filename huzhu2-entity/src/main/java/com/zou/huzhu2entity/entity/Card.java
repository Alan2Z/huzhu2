package com.zou.huzhu2entity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 14:31
 * Project:  huzhu
 * Description: 卡片实体类
 **/
@Data
public class Card implements Serializable {


    private String id;
    private String cardTitle;
    private String cardContent;
    private String cardImg;
    private Integer cardCode;
    private Integer readNum;
    private Integer likeNum;
    private Integer commentNum;
    private Integer delStatus;
    private String createUser;
    private String createName;
    private String createImg;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private String updateUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private String messageId;//消息唯一id


}
