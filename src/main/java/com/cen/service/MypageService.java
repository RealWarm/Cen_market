package com.cen.service;

import com.cen.domain.MemberVO;

public interface MypageService {

	// 게시글의 판매여부를 바꾼다.	
	public void updateProgress(String sb_num, String trade_progress) throws Exception;
	
	// 등록한 게시글을 삭제한다.
	public void deleteBoard(String sb_num) throws Exception;
	
	// 자신이 찜한 내열을 삭제한다.
	public void deleteBook(String sb_num, String sb_writer) throws Exception;
	
	// 회원 정보를 업데이트 한다.
	public void memberUpdate(MemberVO vo) throws Exception;
	
	// 회원 탈퇴를 한다.
	public void memberDelete(String id) throws Exception;
	
	
}//end-interface