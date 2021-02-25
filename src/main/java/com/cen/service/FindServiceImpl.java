package com.cen.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.cen.domain.MemberVO;
import com.cen.persistence.FindDAO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class FindServiceImpl implements FindService {

	@Inject
	FindDAO dao;	
	
	@Override
	public String findId(MemberVO vo) throws Exception {
		log.info("FindServiceImpl :: findId() invoked!!!");
		return dao.findId(vo);
	}//findId

	@Override
	public String findPw(MemberVO vo) throws Exception {
		log.info("FindServiceImpl :: findPw() invoked!!!");
		return dao.findPw(vo);
	}//findPw

	@Override
	public void updatePw(MemberVO vo) throws Exception {
		log.info("FindServiceImpl :: updatePw() invoked!!!");
		dao.updatePw(vo);
	}//updatePw

}//end class
