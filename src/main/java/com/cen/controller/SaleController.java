package com.cen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;



@Log4j
@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@GetMapping("/saleregist")
	public String registGet() throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		return "/saleRegist";
	}//registGet
	
	@PostMapping("/saleregist")
	public String registPost() throws Exception {
		log.info("SaleController :: public String registPost() invoked!!!");
		
		return "redirect:/main";
	}//registPost
	

}//end class
