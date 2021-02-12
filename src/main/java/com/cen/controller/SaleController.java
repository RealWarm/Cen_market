package com.cen.controller;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cen.domain.MemberVO;
import com.cen.domain.ReplyVO;
import com.cen.domain.SboardVO;
import com.cen.domain.ViewVO;
import com.cen.model.SaleRegisterDTO;
import com.cen.model.ViewDTO;
import com.cen.service.BringService;
import com.cen.service.SaleService;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Inject
	SaleService saleservice;
	
	@Inject
	BringService bringService;
		
	@GetMapping("/saleregist")
	public String registGet() throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		return "/saleregist";
	}//registGet
		
	@RequestMapping(value ="/saleregist",
			method = RequestMethod.POST)
	public String registPost(SaleRegisterDTO dto, ViewDTO viewdto,
			@RequestParam("uploadFiles") MultipartFile[] uploadFiles,
			HttpSession session) throws Exception {				
		log.info("SaleController :: public String registPost() invoked!!!");		
		System.out.println("uploadFiles :: " + uploadFiles.length);	
		
		// 게시글의 번호를 설정한다.
		int bd_num=saleservice.boardCnt()+1;		
		dto.setSb_num(bd_num);
		
		// 세션에서 데이터 가져오기
		MemberVO vo = (MemberVO)session.getAttribute("login");
		
		// 세션에서 아이디를 추출해서 넣는다.		
		dto.setSb_writer(vo.getId());		
		
		// 작성자의 닉네임
		dto.setSb_nickname(vo.getNickname());
		
		System.out.println("SaleRegisterDTO :: " + dto);
		///////////////////////////////////////////////////////////
		// 이미지 데이터 등록
		int flag=0;		
		// 이미지에 게시글 번호 설정
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
			// 게시글에 대표이미지 이름을 저장한다.
			if(flag==0) {
				flag=1;
				dto.setSb_view(file.getOriginalFilename());
				// 게시글을 등록합니다. 
				saleservice.insertBoard(dto);
			}//if
			viewdto.setView_name(file.getOriginalFilename());			
			saleservice.insertImage(viewdto);
		}//enhanced for	
		System.out.println("SaleRegisterDTO :: " + dto);
		return "redirect:/main";
	}//registPost
	
	
	@GetMapping("/category")
	public String categoryGet() throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		return "/category_details";
	}//registGet
	
	
	@PostMapping("/category")
	public String categoryPost() throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		return "/category_details";
	}//registGet
	
	
	@GetMapping("/detail")
	public String pddetailGet(@RequestParam("num") Integer num, Model model) throws Exception {
		log.info("SaleController :: public void pddetailGet() invoked!!!");
		
		// 게시글 상세내용 가져오기
		SboardVO bvo = bringService.detail(num);
		
		// 게시글 이미지 모두 가져오기
		List<ViewVO> imglist=bringService.viewAll(num);
		
		// 대표이미지 가져오기
		String topPic=bringService.topPicture(num);
		
		// 댓글정보 모두가져오기
		List<ReplyVO> replylist=bringService.replyAll(num);
		
		System.out.println("SboardVO :: " + bvo);
		System.out.println("imglist :: ===================== ");
		for(ViewVO vv : imglist) {
			System.out.println("==================================");
			System.out.println(vv);
		}//enhanced-for
		model.addAttribute("detail", bvo);
		model.addAttribute("imglist", imglist);	
		model.addAttribute("top", topPic);
		model.addAttribute("reply", replylist);
		return "/product_detail";
	}//registGet
		

	
	
	

}//end class










//@GetMapping("/detail")
//public @ResponseBody SboardVO pddetailGet(@RequestParam("num") Integer num, Model model) throws Exception {
//	log.info("SaleController :: public void pddetailGet() invoked!!!");
//	// 게시글 상세내용 가져오기
//	SboardVO bvo = bringService.detail(num);
//	// 게시글 이미지 모두 가져오기
//	List<ViewVO> imglist=bringService.viewAll(num);
//	// 대표이미지 가져오기
//	String topPic=bringService.topPicture(num);
//	//닉네임 가져오기
//	
//	
//	System.out.println("SboardVO :: " + bvo);
//	System.out.println("imglist :: ===================== ");
//	for(ViewVO vv : imglist) {
//		System.out.println("==================================");
//		System.out.println(vv);
//	}//enhanced-for
//	model.addAttribute("detail", bvo);
//	model.addAttribute("imglist", imglist);	
//	model.addAttribute("top", topPic);
//	return bvo;
//}//registGet