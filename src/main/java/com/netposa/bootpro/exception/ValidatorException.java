package com.netposa.bootpro.exception;

import org.springframework.validation.BindingResult;

public class ValidatorException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1658028815603554413L;
	private BindingResult bindingResult;

	public ValidatorException(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
}
