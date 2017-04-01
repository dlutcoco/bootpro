package com.netposa.bootpro.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.netposa.bootpro.entites.BaseResponse;
import com.netposa.bootpro.exception.ValidatorException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public BaseResponse handlerException(Exception e, HttpServletRequest request) {
        BaseResponse response = new BaseResponse();
        
        if (e instanceof ValidatorException) {
            response.code(400).message("请求参数错误");
            ValidatorException ex = (ValidatorException) e;
            for (ObjectError error : ex.getBindingResult().getAllErrors()) {
                response.put(error.getObjectName(), error.getDefaultMessage());
            }
            return new BaseResponse();
        }
        return response;
    }
}
