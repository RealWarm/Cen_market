package com.cen.persistence;

import com.cen.domain.MemberVO;

public interface RegisterDAO {
	
	// 회원등록
	public void register(MemberVO vo) throws Exception;

}//end interface
