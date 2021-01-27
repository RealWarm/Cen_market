package com.cen.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.cen.domain.MemberVO;
import com.cen.persistence.RegisterDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RegisterServiceImpl implements RegisterService {
	
	@Inject
	RegisterDAO dao;
	
	@Override
	public void register(MemberVO vo) throws Exception {
		log.info("RegisterServiceImpl:: public void register(MemberVO vo) invoked!!!");
		dao.register(vo);
	}//register
	
	

}//end class
