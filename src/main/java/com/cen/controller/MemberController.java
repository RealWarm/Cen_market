package com.cen.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cen.domain.MemberVO;
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
	public String registerPost(MemberVO vo, @RequestParam("org_name") String org_name) throws Exception{
		// 폼에서 입력값을 받아 옵니다. 
		// 기관명을 이용하여 기관코드를 얻고
		// 기관코드를 이용하여 기관주소를 가져와서 recent_address에 입력합니다.
		log.info("MemberController :: public String registerPost() invoked!!!!");		
		System.out.println("before :: " + vo);
		registerService.register(vo);
		return "redirect:/main";		
	}//joinGet
		
	
	// 회원 가입 형식 검사
	@ResponseBody
	@PostMapping("/idcheck")
	public int idCheck(@RequestParam("id") String uid) throws Exception {
		return registerService.idCheck(uid);
	}//idCheck
	
	@ResponseBody
	@PostMapping("/emailcheck")
	public int emailCheck(@RequestParam("password") String upw) throws Exception {
		return registerService.emailCheck(upw);
	}//emailcheck
	
	@ResponseBody
	@PostMapping("/nickcheck")
	public int nickCheck(@RequestParam("nickname") String nick) throws Exception {
		return registerService.emailCheck(nick);
	}//nickCheck
	
	
	
	

}//end class
