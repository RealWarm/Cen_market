package com.cen.persistence;

import com.cen.domain.MemberVO;
import com.cen.model.LoginDTO;

public interface LoginDAO {
	
		public MemberVO login(LoginDTO dto) throws Exception;		
		
}//end interface
