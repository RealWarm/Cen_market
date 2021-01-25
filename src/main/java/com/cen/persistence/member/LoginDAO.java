package com.cen.persistence.member;

import com.cen.model.LoginDTO;

public interface LoginDAO {
	
		public Boolean login(LoginDTO dto) throws Exception;		
		
		public void logout() throws Exception;

}//end interface
