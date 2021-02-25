package com.cen.service;

import com.cen.domain.MemberVO;

public interface FindService {
	
	public String findId(MemberVO vo) throws Exception;
	
	public String findPw(MemberVO vo) throws Exception;
	
	public void updatePw(MemberVO vo) throws Exception;
	
}//end-interface
