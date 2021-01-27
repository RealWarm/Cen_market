package com.cen.service;

import com.cen.domain.MemberVO;


public interface RegisterService {
	
	// 회원등록
	public void register(MemberVO vo) throws Exception;
	
	// 기관 이름으로 기관 번호를 찾는다.
	public int find_OrgCode(String org_name) throws Exception;

	// 기관 번호로 기관 주소를 찾는다.
	public String find_OrgAddress(int org_code) throws Exception;
	
}//end interface
