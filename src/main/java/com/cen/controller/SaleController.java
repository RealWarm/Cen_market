package com.cen.controller;

import java.io.File;

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
	
	
	@RequestMapping(value ="/saleregist",
			method = RequestMethod.POST)
	public String registPost(SaleRegisterDTO dto,			
			@RequestParam("uploadFiles") MultipartFile[] uploadFiles) throws Exception {
		
		log.info("SaleController :: public String registPost() invoked!!!");		
		System.out.println("uploadFiles :: " + uploadFiles.length);
		System.out.println("SaleRegisterDTO :: " + dto);
		
		
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
			
			// 파일을 정해진 위치에 저장하기
			String uploadTempPath = "C:\\App";
			String uploadTaregtPath = "C:\\App\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\workspace2\\cen_market\\src\\main\\webapp\\resources\\upload_data";
			
			File f = new File(uploadTempPath, file.getOriginalFilename());
			f.deleteOnExit();  // **** 중요2 ****
			
			// 지정된 임시경로에 수신한 파일저장
			file.transferTo(f);
			
			// (**매우 중요 **)임시경로에 저장된 파일을 
			// 최종 타겟 폴더에 저장
			f.renameTo(
				new File(
						uploadTaregtPath, 
						file.getOriginalFilename()
					)
			);//최종 타겟 폴더로 Move
						
		}//enhanced for
		
		
		
		return "redirect:/main";
	}//registPost
	

}//end class
