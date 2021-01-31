package com.cen.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cen.domain.MemberVO;
import com.cen.model.LoginDTO;
import com.cen.service.LoginService;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/")
public class MainController {

	@Inject
	LoginService loginService;	
		
	@GetMapping("/login")
	public String loginGet() throws Exception {		
		log.info("MainController :: public String main() invoked!!!!");		
		return "login";		
	}//main

	
	@PostMapping("/login_Post")
	public String loginPost(HttpServletRequest request, LoginDTO dto) throws Exception{		
		log.info("MainController :: public String login_Post() invoked!!!!");
		
		System.out.println("+++++++" + dto);
		MemberVO vo= loginService.login(dto);
		System.out.println("+++++++" + vo);
		
		if(vo==null) {
			log.info("login fail!!!!!!!!");
			return "redirect:/";
		}else {
			log.info("login success!!!!!!!!!");
			HttpSession session = request.getSession();
			session.setAttribute("login", vo);			
			return "/main";
		}//if
		
	}//login
	
	// 로그인 체크 확인
	@ResponseBody
	@PostMapping("/login_check")	
	public MemberVO loginCheck(LoginDTO dto) throws Exception{
		log.info("MainController :: loginCheck() invoked!!!!");		
		return loginService.login(dto);
	}//loginCheck
	
	@GetMapping("/main")
	public String main() throws Exception {		
		log.info("MainController :: public String main() invoked!!!!");		
		return "/main";		
	}//main

//	@PostMapping("/login_Post")
//	public String login_result(HttpServletRequest request,
//								LoginDTO dto, Model model) throws Exception {
//		log.info("POST-Login");
//
//		String encryPassword = Sha256.encrypt(dto.getUserpw()); // 비번 암호화
//		dto.setUserpw(encryPassword);
//
//		MemberVO vo = loginService.login(dto);
//           
//      	if(vo==null) {
//			log.info("login fail!!!!!!!!");
//			return "redirect:/login";
//		}else {
//			log.info("login success!!!!!!!!!");
//			HttpSession session = request.getSession();
//			session.setAttribute("login", vo);			
//			return "main";
//		}//if
//      	
//   }// login_POST
		
}//main
