package com.cen.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cen.domain.MemberVO;
import com.cen.model.ReplyDTO;
import com.cen.security.Sha256;
import com.cen.service.RegisterService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Inject
	RegisterService registerService;
	
	@GetMapping("/mypage")
	public String mypageGet() throws Exception{
		log.info("MemberController :: public String mypageGet() invoked!!!!");		
		return "mypage";		
	}//joinGet
	
	@GetMapping("/confirm")
	public String confirmGet() throws Exception{
		log.info("MemberController :: public String confirmGet() invoked!!!!");		
		return "confirm";		
	}//joinGet
	
	@GetMapping("/register")
	public String registerGet() throws Exception{
		log.info("MemberController :: public String registerGet() invoked!!!!");		
		return "register";		
	}//joinGet
	
	
	@PostMapping("/register")
	public String registerPost(MemberVO vo) throws Exception{
		// 폼에서 입력값을 받아 옵니다. 
		// 기관명을 이용하여 기관코드를 얻고
		// 기관코드를 이용하여 기관주소를 가져와서 recent_address에 입력합니다.
		log.info("MemberController :: public String registerPost() invoked!!!!");		
		System.out.println("before :: " + vo);
		String encryPassword = Sha256.encrypt(vo.getPassword()); // 비번 암호화
		vo.setPassword(encryPassword);
		System.out.println("after :: " + vo);
		registerService.register(vo);
		return "redirect:/main";		
	}//joinGet
	
	// 댓글 달기
	@PostMapping("/reply")
	public String replyPost(ReplyDTO dto, HttpSession session,  
			@RequestParam(value="num", required=false) String nnnn) throws Exception{
		log.info("MemberController :: public String replyPost() invoked!!!!");		
		System.out.println("+++++++++num :: " + nnnn);
		System.out.println("ReplyDTO :: " + dto + "!!!!!");
		MemberVO vo = (MemberVO)session.getAttribute("login");
		System.out.println("+++++++++++++ vo :: " + vo);
		dto.setSb_writer(vo.getId());
		dto.setSb_nickname(vo.getNickname());
		registerService.registReply(dto);
		System.out.println("ReplyDTO :: " + dto + "!!!!!");
		return "redirect:/sale/detail"+"?num="+dto.getSb_num();	
	}//replyPost
	
	// 찜하기
	@GetMapping("/bookmark")
	public String bookmarkGet(HttpSession session,  
			@RequestParam(value="sb_num", required=false) String sb_num) throws Exception{
		log.info("MemberController :: public String bookmarkGet() invoked!!!!");
		MemberVO vo = (MemberVO)session.getAttribute("login");
		String sb_writer=vo.getId();
		System.out.println("++++++++++++ " + sb_num + " :::: " + sb_writer);
		int cnt=registerService.getbookCnt(sb_num, sb_writer);
		System.out.println("@@@@@@@ 갯수는 " + cnt +"개 입니다.");
		if(cnt==0) {
			registerService.bookMark(sb_num, sb_writer);
		}//if				
		// return "redirect:/sale/detail"+"?num="+sb_num;	
		return "redirect:/member/mypage";
	}//bookmarkGet
	
	
	// 회원 가입 형식 검사
	@ResponseBody
	@PostMapping("/idcheck")
	public int idCheck(@RequestParam("id") String uid) throws Exception {
		return registerService.idCheck(uid);
	}//idCheck
	
	@ResponseBody
	@PostMapping("/emailcheck")
	public int emailCheck(@RequestParam("email") String upw) throws Exception {
		return registerService.emailCheck(upw);
	}//emailcheck
	
	@ResponseBody
	@PostMapping("/nickcheck")
	public int nickCheck(@RequestParam("nickname") String nick) throws Exception {
		return registerService.nickCheck(nick);
	}//nickCheck
	
	
	
	

}//end class
