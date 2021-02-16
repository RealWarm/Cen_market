package com.cen.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cen.domain.MemberVO;
import com.cen.service.MypageService;
import com.cen.service.RegisterService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/info")
public class ClientController {
	
	@Inject
	RegisterService registerService;
	
	@Inject
	MypageService mypageService;
	
	// 정보수정 페이지로 이동!
	@GetMapping("/update")
	public String infoUpdate() throws Exception{
		log.info("ClientController :: public String infoUpdate() invoked!!!");
		
		return"member_modify";
	}//infoUpdate
	
	// 게시글의 판매진행을 변경한다.
	@PostMapping("/mypage/progress")
	public String progressUpdate(@RequestParam(value="sb_num", required=false) String sb_num,
								 @RequestParam(value="trade_progress", required=false) String trade_progress) throws Exception{
		log.info("ClientController :: public String progressUpdate() invoked!!!");
		mypageService.updateProgress(sb_num, trade_progress);
		return "redirect:/member/mypage";
	}//progressUpdate
	
	// 게시글을 삭제한다.
	@PostMapping("/mypage/cancel")
	public String boardDelet(@RequestParam(value="sb_num", required=false) String sb_num) throws Exception{
		log.info("ClientController :: public String boardDelet() invoked!!!");
		mypageService.deleteBoard(sb_num);
		return "redirect:/member/mypage";
	}//boardDelet
	
	// 북마크를 삭제한다.
	@PostMapping("/mypage/bookcancel")
	public String bookCancel(@RequestParam(value="sb_num", required=false) String sb_num,
			HttpServletRequest request) throws Exception{
		log.info("ClientController :: public String bookCancel() invoked!!!");
		HttpSession session = request.getSession();
		MemberVO vo=(MemberVO)session.getAttribute("login");
		String sb_writer=vo.getId();
		mypageService.deleteBook(sb_num, sb_writer);		
		return "redirect:/member/mypage";
	}//bookCancel

}//end class

























