package com.cen.service;

import com.cen.domain.MemberVO;
import com.cen.model.LoginDTO;

public interface LoginService {
	
	public MemberVO login(LoginDTO dto) throws Exception;

}//interface
