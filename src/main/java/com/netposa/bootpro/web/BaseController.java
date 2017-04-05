package com.netposa.bootpro.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.netposa.bootpro.entites.BaseResponse;

@RestControllerAdvice
public class BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
    @ExceptionHandler(Exception.class)
    public BaseResponse handlerException(Exception e, HttpServletRequest request) {
        LOG.error("", e);
        return new BaseResponse(500);
    }
}
