package com.cen.service;

import com.cen.domain.MemberVO;


public interface RegisterService {
	
	// 회원등록
	public void register(MemberVO vo) throws Exception;

}//end interface
