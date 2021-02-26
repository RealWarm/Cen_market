package com.cen.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cen.domain.MemberVO;
import com.cen.email.Email;
import com.cen.email.EmailAuthenNum;
import com.cen.email.EmailSender;
import com.cen.security.Sha256;
import com.cen.service.FindService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/find")
public class AuthController {
	
	@Inject
	private FindService findservice;
	
	@Autowired
	private Email email;
	
	@Autowired
	private EmailSender emailSender;
	
	
	// 아이디 찾기
	
	@GetMapping("/find_id")
    public String idfind() {    	
		log.info("AuthController :: GET::idfind() invoked!!!");		
		return "/find_id";
    }//idfind
	
	@PostMapping("/find_id")         
    public String idfind_POST(MemberVO vo) throws Exception {
		log.info("AuthController :: idfind_POST() invoked!!!");	
		System.out.println("아이디 찾기 페이지에서 받은 값 :: " + vo);		
		String id = findservice.findId(vo);
		System.out.println("찾은 아이디 :: " + id);
		vo.setId(id);
		String mail=vo.getEmail();
		String name=vo.getName();
		
		if(id!=null) {	
			email.setContent("아이디는 "+id+" 입니다");
			email.setReceiver(mail);
			email.setSubject(name+"님 나라중고장터 'ID' 찾기 메일입니다");
			emailSender.SendEmail(email);
			log.info(mail +"로아이디값 전송 !");
		}else {
//			return "redirect:/find/find_id";
			return "/login";
		}//if-else				
		return "/login";	
	} //find_id
	
	// 비밀번호 찾기
	@GetMapping("/find_pw")
    public String Get_findpw() {
		log.info("AuthController :: findpwd_GET() invoked!!!");
		return "/find_pw";
	}//findpwd_GET
	
	@PostMapping("/find_pw")
	public String Post_findPw(MemberVO vo) throws Exception {
		log.info("AuthController :: Post_findPw() invoked!!!");
		
		String mail=vo.getEmail();
    	String id=vo.getId();
    	String password = findservice.findPw(vo);
    	
    	// 새로운 비밀번호 6자리 생성
    	String newPassword = EmailAuthenNum.AuthenNum();    
    	log.info("newPassword:" + newPassword);
    	
    	// 새로운 비밀번호 6자리를 암호화한다.
    	String encryPassword = Sha256.encrypt(newPassword);    	
    	vo.setPassword(encryPassword);
    	
    	if(password!=null) {    		
    		email.setContent("임시 비밀번호는 "+newPassword+" 입니다");
    		email.setReceiver(mail);
    		email.setSubject(id+"님 나라중고장터 'password' 찾기 메일입니다");
    		emailSender.SendEmail(email);
    		log.info(mail +"로아이디값 전송 !");
    		findservice.updatePw(vo);    		
    	}else {
//    		return "redirect:/find/find_pw";
    		return "/login";
    	}//if-else    	
    	return "/login";    	
	}//Post_findPw
	
	

}//end class


















