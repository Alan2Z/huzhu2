package com.zou.huzhu2common.utils;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 16:12
 * Project:  huzhu
 * Description:
 **/
public enum  ErrorCode {


    SYSTEM_ERROR(400,"系统错误"),
    IMAGE_UPLOAD_FAILED(600,"图片上传失败"),


    USER_LOGIN_FAILED(501,"登陆失败"),
    USER_AUTHORIZATION_FAILED(401,"认证信息已过期，请重新登陆"),
    USER_NOT_FOUND(503,"用户不存在"),
    CARD_PUBLISH_FAILED(511,"发布卡片失败"),
    ;


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
