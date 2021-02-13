package com.cen.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cen.domain.MainVO;
import com.cen.domain.MemberVO;
import com.cen.model.LoginDTO;
import com.cen.service.BringService;
import com.cen.service.LoginService;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/")
public class MainController {

	@Inject
	LoginService loginService;	
	
	@Inject
	BringService bringService;
	
	// 메인페이지 호출
	@GetMapping("/main")
	public String main(HttpSession session, Model model) throws Exception {		
		log.info("MainController :: public String main() invoked!!!!");		
		MemberVO vo = (MemberVO)session.getAttribute("login");
		System.out.println("login :: " + vo + "!!!!!!");
		//////////////////////////////////////////////
		List<MainVO> mlist=bringService.mainListAll();
		for(MainVO nvo:mlist) {
			System.out.println(nvo);
		}//enhanced-for
		model.addAttribute("mlist", mlist);		
		return "/main";		
	}//main
		
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
			return "redirect:/main";
		}//if
		
	}//login
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("로그아웃!!");
		session.removeAttribute("login");
		return "redirect:/";
	}
	
	
	// 로그인 체크 확인
	@ResponseBody
	@PostMapping("/login_check")	
	public Integer loginCheck(LoginDTO dto) throws Exception{
		log.info("MainController :: loginCheck() invoked!!!!");		
		return loginService.login_chk(dto);
	}//loginCheck
	
	
	
	

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
