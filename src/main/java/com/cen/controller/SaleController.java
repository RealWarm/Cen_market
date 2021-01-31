package com.cen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cen.model.SaleRegisterDTO;

import lombok.extern.log4j.Log4j;



@Log4j
@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@GetMapping("/saleregist")
	public String registGet() throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		return "/saleregist";
	}//registGet
	
	// @PostMapping("/saleregist")
	@RequestMapping(value ="/saleregist",
			method = RequestMethod.POST)
	public String registPost(@RequestParam("uploadFile") MultipartFile[] uploadFiles)						  
							 throws Exception {
		log.info("SaleController :: public String registPost() invoked!!!");
		System.out.println("uploadFiles :: " + uploadFiles.length);
		
		for(MultipartFile file : uploadFiles) {
			log.info("\t\t =================================");
			log.info("\t\t* 1. contentType: "		+file.getContentType());
			log.info("\t\t* 2. name: "				+file.getName());
			log.info("\t\t* 3. originalFilename: "	+file.getOriginalFilename());
			log.info("\t\t* 4. size: "				+file.getSize());
			log.info("\t\t* 5. clazz: "				+file.getClass());
			log.info("\t\t* 6. resource: "			+file.getResource());
			log.info("\t\t* 7. byte[]: "			+file.getBytes().length);
			log.info("\t\t* 8. isEmpty: "			+file.isEmpty());
		}//enhanced-for
		
		
		
		return "redirect:/main";
	}//registPost
	

}//end class
