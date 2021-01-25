package com.cen.persistence.member;

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
	public Boolean login(LoginDTO dto) throws Exception {		
		log.info("LoginDAOImpl::public Boolean login(LoginDTO dto) invoked!!");
		MemberVO vo = sqlSession.selectOne(namespace + ".login", dto);
		
		if(vo==null) {
			return false;
		}else {
			return true;
		}//if
		
	}//login

	@Override
	public void logout() throws Exception {		
		
	}//logout

}//endclass
