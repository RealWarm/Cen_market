package com.cen.persistence.member;

import com.cen.domain.MemberVO;

public interface RegisterDAO {
	
	// 회원가입
	public void register(MemberVO vo) throws Exception;

}//end interface
