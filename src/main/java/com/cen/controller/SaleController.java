package com.cen.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	private SaleService saleservice;
	
	@Inject
	private BringService bringService;
		
	@GetMapping("/saleregist")
	public String registGet() throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		return "/saleregist";
	}//registGet
		
	@RequestMapping(value ="/saleregist", method = RequestMethod.POST)
	public String registPost(SaleRegisterDTO dto, ViewDTO viewdto, HttpServletRequest request,
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
			String uploadTaregtPath = request.getSession().getServletContext().getRealPath("/")+"/resources/upload_data";
			System.out.println("+_+_+_+_+_+_+ "+request.getSession().getServletContext().getRealPath("/"));
			
			String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
	        uuid = uuid.substring(0,6); //uuid를 앞에서부터 6자리 잘라줌.			
			
			String savedName = uuid.toString() + "_" + file.getOriginalFilename();	
			File f = new File(uploadTaregtPath, savedName);
			file.transferTo(f);
			
			
//			String uploadTempPath = " ";			
//			String uploadTaregtPath = " ";
//			File f = new File(uploadTempPath, file.getOriginalFilename());
//			f.deleteOnExit();  // **** 중요2 ****
//			
//			// 지정된 임시경로에 수신한 파일저장
//			file.transferTo(f);
//			
//			// (**매우 중요 **)임시경로에 저장된 파일을 
//			// 최종 타겟 폴더에 저장
//			f.renameTo(
//				new File(
//						uploadTaregtPath, 
//						file.getOriginalFilename()
//					)
//			);//최종 타겟 폴더로 Move
			
			// 이미지의 이름을 저장함 >> 확장자가 다양할수 있으므로 확장자까지 모두 저장한다.
			// 게시글에 대표이미지 이름을 저장한다.
			// 이미지에 고유한 번호를 등록한다.
					
			if(flag==0) {
				flag=1;
				dto.setSb_view(savedName);
				// 게시글을 등록합니다. 
				saleservice.insertBoard(dto);
			}//if
			viewdto.setView_name(savedName);			
			saleservice.insertImage(viewdto);
		}//enhanced for	
		
		// 사용자의 최근 거래지역을 갱신한다.
		saleservice.updateRecentAddress(vo.getId(), dto.getTrade_area());		
		System.out.println("SaleRegisterDTO :: " + dto);
		return "redirect:/";
	}//registPost
		
	
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
//		for(ViewVO vv : imglist) {
//			System.out.println("==================================");
//			System.out.println(vv);
//		}//enhanced-for
		
		model.addAttribute("detail", bvo);
		model.addAttribute("imglist", imglist);	
		model.addAttribute("top", topPic);
		model.addAttribute("reply", replylist);
		
		return "/product_detail";
	}//registGet
	
	
	//게시글 수정을 위한 데이터를 가져온다.
	@GetMapping("/detailmodify")
	public String detailmodify(@RequestParam("sb_num") Integer num, Model model) throws Exception{
				
		// 게시글 상세내용 가져오기
		SboardVO bvo = bringService.detail(num);
		
		// 게시글 이미지 모두 가져오기
		List<ViewVO> imglist=bringService.viewAll(num);
				
		model.addAttribute("detail", bvo);
		model.addAttribute("imglist", imglist);
		
		return "detailmodify";
	}//detailmodify
	
	
//	System.out.println("uploadFiles :: " + uploadFiles);	
//	System.out.println("sb_num :: " + num);
//	System.out.println("SboardVO :: " + vo);		
	
	//게시글 수정을 위한 데이터를 가져온다.
	@PostMapping("/detailmodify")
	public String Postdetailmodify(@RequestParam("uploadFiles") MultipartFile[] uploadFiles,
			@RequestParam("sb_num") Integer num, SboardVO vo, ViewDTO viewdto,
			HttpServletRequest request) throws Exception{
		vo.setSb_num(num);
		viewdto.setSb_num(num);
		
		// 추가할 사진이 한장이 이라도 잇다면.
		if(uploadFiles.length>0) {
			String uploadTaregtPath = request.getSession().getServletContext().getRealPath("/")+"/resources/upload_data";			
			for(MultipartFile file : uploadFiles) {
				// 파일을 정해진 위치에 저장하기						
				UUID uid = UUID.randomUUID();		
				String savedName = uid.toString() + "_" + file.getOriginalFilename();	
				File f = new File(uploadTaregtPath, savedName);
				file.transferTo(f);
				
				viewdto.setView_name(savedName);			
				saleservice.insertImage(viewdto);
			}//enhanced-for
		}//if
		
		// 입력 받은 나머지 내용들을 업데이트 한다.
		saleservice.updateSaleBorad(vo);
		
		return "redirect:/sale/detail"+"?num="+num;
	}//detailmodify
	
	
	
	@ResponseBody
	// @PostMapping("/getorg")
	@RequestMapping(value= "/getorg", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")	
	public String getOrg(HttpSession session) throws Exception{
		log.info("SaleController :: public String getOrg() invoked!!!");
		MemberVO vo = (MemberVO)session.getAttribute("login");
		return saleservice.getOrgName(vo.getId());
	}//getOrg
	
	@ResponseBody
	// @PostMapping("/getrecentaddress")
	@RequestMapping(value= "/getrecentaddress", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String getRecentAddress(HttpSession session) throws Exception{
		log.info("SaleController :: public String getRecentAddress() invoked!!!");
		MemberVO vo = (MemberVO)session.getAttribute("login");
		return saleservice.getRecentAddress(vo.getId());
	}//getOrg
	
	
	

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