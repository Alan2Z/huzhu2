package com.zou.huzhu2entity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 14:51
 * Project:  huzhu
 * Description: 积分记录实体类
 **/
@Data
public class CurrencyRecord implements Serializable{

    private String id;
    private Integer action;
    private String content;
    private Integer currency;
    private Integer type;
    private String createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
