package com.cen.controller;

import java.io.File;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cen.model.SaleRegisterDTO;
import com.cen.model.ViewDTO;
import com.cen.service.SaleService;

import lombok.extern.log4j.Log4j;



@Log4j
@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Inject
	SaleService saleservice;
		
	@GetMapping("/saleregist")
	public String registGet() throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		return "/saleregist";
	}//registGet
	
	
//		sboard 테이블에 데이터를 집어넣고, 해당 게시글번호에 맞는 이지 이름들을 저장한다.
//		private int sb_num;					/* 게시글 번호 해쉬를 이용한 인조키 */ 	>> 데이터베이스에서 번호를 가져온다은 넣는다.
//		private String sb_writer; 			/* 작성자의 아이디(FK) */			>> 세션에서 추출한다.
//		private String sb_name;  			/* 게시글의 제목 */				
//		private String sb_detail;			/* 판매상품의 설명 */				 
//    
//    	private int Total_price;			/* 총 판매 금액 */
//   	private int Total_quantity;			/* 총 판매수량 */
		// private Timestamp sb_regdate;	/* 게시글 등록일 */				>> sysdate써서 지금의
//    	private int ct_num;					/* 카테고리 번호(FK) */
//    	private String trade_shape;			/* 거래 형태 */
//    	private String trade_progress;		/* 거래 진행 상황 */				>> "판매중"으로 초기화
		// private String recent_address;	// 발송주소					>>
	
	// 이미지 이름을 데이터베이스에 넣는다.
	// 서비스 만들기 
	// 1. 데이터베이스 게시글 갯수 세는 서비스 >> 추후에 암호화도 가능할거같음 
	// 2. 게시글을 데이터베이스에 넣는다.
	// 3. 이미지들을 데이터베이스에 넣는다.
	
	@RequestMapping(value ="/saleregist",
			method = RequestMethod.POST)
	public String registPost(SaleRegisterDTO dto, ViewDTO viewdto,
			@RequestParam("uploadFiles") MultipartFile[] uploadFiles) throws Exception {
				
		log.info("SaleController :: public String registPost() invoked!!!");		
		System.out.println("uploadFiles :: " + uploadFiles.length);
		System.out.println("SaleRegisterDTO :: " + dto);
		
		// 게시글의 번호를 설정한다.
		int bd_num=saleservice.boardCnt() + 1;  
		dto.setSb_num(bd_num);
		
		// 세션에서 아이디를 추출해서 넣는다.
		dto.setSb_writer("testid1");
				
		// 카테고리번호 임시지정
		dto.setCt_num(110);		

		// 거래진행 상황을 판매중으로 초기화 한다.
		dto.setTrade_progress("판매중");
		
		// 게시글을 등록합니다. 
		saleservice.insertBoard(dto);
		///////////////////////////////////////////////////////////
		// 이미지 데이터 등록
		
		// 게시글의 번호 설정
		viewdto.setSb_num(bd_num);
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
			
			// 이미지의 이름을 저장함 >> 확장자가 다양할수 있으므로 확장자까지 모두 저장한다.
			viewdto.setView_name(file.getOriginalFilename());			
			saleservice.insertImage(viewdto);
		}//enhanced for
		
		
		
		return "redirect:/main";
	}//registPost
	

}//end class
