package com.zou.huzhu2common.exception;

import com.zou.huzhu2common.utils.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 16:19
 * Project:  huzhu
 * Description:
 **/
@ControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(UserException.class)
    @ResponseBody
    public Response userExceptionHandler(UserException ue){
        return Response.error(ue.getErrorCode());
    }


}
