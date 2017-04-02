package com.netposa.bootpro.web;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netposa.bootpro.entites.BaseResponse;
import com.netposa.bootpro.exception.ValidatorException;
import com.netposa.bootpro.vo.UserVo;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public BaseResponse addUser(@Validated UserVo userVo, BindingResult bindingResult) {
        List<ObjectError> errors = bindingResult.getAllErrors();
        for (ObjectError error : errors) {
            System.out.println(error.getCode() + "-" + error.getObjectName() + "-" + error.getDefaultMessage());
        }
        
        if (bindingResult.hasErrors()) {
            throw new ValidatorException(bindingResult);
        }

        return new BaseResponse();
    }
}
