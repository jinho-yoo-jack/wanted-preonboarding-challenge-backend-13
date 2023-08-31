package com.wanted.preonboarding.global;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler({Exception.class})
	public String handleException(Exception e) {
		return e.getMessage();
	}
}
