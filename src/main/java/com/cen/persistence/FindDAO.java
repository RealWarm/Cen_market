package com.cen.persistence;

import com.cen.domain.MemberVO;

public interface FindDAO {
	
	public String findId(MemberVO vo) throws Exception;
	
	public String findPw(MemberVO vo) throws Exception;
	
	public void updatePw(MemberVO vo) throws Exception;
	
}//end-interface
