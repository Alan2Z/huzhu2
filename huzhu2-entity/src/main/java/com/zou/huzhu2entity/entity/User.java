package com.zou.huzhu2entity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 14:26
 * Project:  huzhu
 * Description: 用户实体类
 **/
@Data
public class User implements Serializable {


    private String id;
    private String username;
    private String password;
    private String userPhone;
    private String userSex;
    private String userImg;
    private Integer userRole;
    private Integer checkIn;
    private Integer checkTotal;
    private Integer checkKeep;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime checkDate;
    private Integer currency;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private Integer delStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loginTime;

}
