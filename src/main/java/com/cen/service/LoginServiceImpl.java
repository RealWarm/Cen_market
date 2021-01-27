package com.cen.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.cen.domain.MemberVO;
import com.cen.model.LoginDTO;
import com.cen.persistence.LoginDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class LoginServiceImpl implements LoginService {

	@Inject
	LoginDAO dao;

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {		
		return dao.login(dto);
	}//login
	

}//end class
