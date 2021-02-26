package com.cen.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

	
	@ExceptionHandler(Exception.class)
	private ModelAndView erroException(Exception ex) {	
		log.info(ex.toString());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/error_exception");
		mv.addObject("exception", ex);		
		return mv;
	}//erroException		
	
	
}//end class





