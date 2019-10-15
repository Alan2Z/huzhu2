package com.zou.huzhu2common.utils;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 16:04
 * Project:  huzhu
 * Description:
 **/
public class Response {

    private int code;
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response success(){
        return new Response(200,"success");
    }

    public static Response success(Object data){
        return new Response(200,"success",data);
    }

    public static Response success(int code,String msg){
        return new Response(code,msg);
    }

    public static Response success(int code,String msg,Object data){
        return new Response(code,msg,data);
    }

    public static Response error(){
        return new Response(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMsg());
    }

    public static Response error(int code,String msg){
        return new Response(code,msg);
    }

    public static Response error(int code,String msg,Object data){
        return new Response(code,msg,data);
    }

    public static Response error(ErrorCode errorCode){
        return new Response(errorCode.getCode(),errorCode.getMsg());
    }



}
