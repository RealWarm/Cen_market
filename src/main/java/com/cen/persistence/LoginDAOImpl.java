package com.cen.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cen.domain.MemberVO;
import com.cen.model.LoginDTO;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Repository
public class LoginDAOImpl implements LoginDAO{
	
	
	@Inject
	private SqlSession sqlSession;
	
	private final String namespace="com.cen.mapper.MemberMapper";
		
	@Override
	public MemberVO login(LoginDTO dto) throws Exception {		
		log.info("LoginDAOImpl::public Boolean login(LoginDTO dto) invoked!!");
		MemberVO vo = sqlSession.selectOne(namespace + ".login", dto);
		System.out.println(vo);
		
		if(vo==null) {
			return null;
		}else {
			return vo;
		}//if
		
	}//login

}//endclass
