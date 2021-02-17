package com.cen.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cen.service.BringService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Inject
	BringService bringService;
	
	
	@GetMapping("/greate")
	public String categoryGet(@RequestParam("ct_num") String ct_num, Model model) throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		
		return "/category_details";
	}//categoryGet
	
	
	@PostMapping("/greate")
	public String categoryPost() throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		return "/category_details";
	}//categoryPost
	
	

}//end class
