package com.cen.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String main() throws Exception {		
		log.info("MainController :: public String main() invoked!!!!");		
		return "login";		
	}//main
	
	@PostMapping("/login_Post")
	public String login(HttpServletRequest request, LoginDTO dto) throws Exception{
		
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
			return "main";
		}//if
		
	}//login
	
	@GetMapping("/join")
	public String joinGet() throws Exception{
		log.info("MainController :: public String joinGet() invoked!!!!");		
		return "join";		
	}//joinGet
	
	
	@PostMapping("/join")
	public String joinPost() throws Exception{
		log.info("MainController :: public String joinPost() invoked!!!!");
		
		return "join";		
	}//joinGet
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//main
