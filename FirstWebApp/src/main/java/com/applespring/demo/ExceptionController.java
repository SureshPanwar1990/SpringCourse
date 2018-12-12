package com.applespring.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController 
{
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(Model m, Exception e)
	{
		System.out.println("runtime exception ...");
		m.addAttribute("exception", e);
		return "exception";
	}
}
