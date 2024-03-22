package com.abstractionizer.Hello.World.handler;

import com.abstractionizer.Hello.World.exception.BusinessException;
import com.abstractionizer.Hello.World.response.ErrorResp;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResp> handleBusinessException(BusinessException ex){
        return new ResponseEntity<>(new ErrorResp(ex.getCode(), ex.getMessage(), ex.getDetails()), HttpStatusCode.valueOf(ex.getHttpStatus()));
    }
}
