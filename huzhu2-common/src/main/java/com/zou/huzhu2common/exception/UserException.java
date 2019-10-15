package com.zou.huzhu2common.exception;

import com.zou.huzhu2common.utils.ErrorCode;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 16:18
 * Project:  huzhu
 * Description:
 **/
public class UserException extends RuntimeException {

    private ErrorCode errorCode;

    public UserException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
