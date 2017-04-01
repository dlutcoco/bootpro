package com.netposa.bootpro.web;

import org.springframework.validation.BindingResult;
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
        if (bindingResult.hasErrors()) {
            throw new ValidatorException(bindingResult);
        }

        return new BaseResponse();
    }
}
