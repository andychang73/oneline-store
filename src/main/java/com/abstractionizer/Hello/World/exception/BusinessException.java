package com.abstractionizer.Hello.World.exception;

import com.abstractionizer.Hello.World.error.BaseError;

public class BusinessException extends BaseException{

    public BusinessException(BaseError error){
        this(error, null);
    }

    public BusinessException(BaseError error, String details){
        this(error.getHttpStatus(), error.getCode(), error.message(), details);
    }
    public BusinessException(int httpStatus, String code, String message, String details){
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.details = details;
    }
}
