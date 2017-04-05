package com.netposa.bootpro.exception;

import org.springframework.validation.BindingResult;

public class ValidatorException extends RuntimeException {

    /**
      * @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么）
      */
    private static final long serialVersionUID = 1988999736750266568L;

    private BindingResult bindingResult;
    
    public ValidatorException(BindingResult bindingResult) {
        super();
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
