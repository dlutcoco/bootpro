package com.netposa.bootpro.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.netposa.bootpro.entites.BaseResponse;

@RestControllerAdvice
public class BaseController {

    @ExceptionHandler(Exception.class)
    public BaseResponse handlerException(Exception e, HttpServletRequest request) {
        
        return new BaseResponse(500);
    }
}
