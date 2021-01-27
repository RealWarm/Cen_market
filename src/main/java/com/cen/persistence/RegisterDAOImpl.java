package com.cen.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cen.domain.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RegisterDAOImpl implements RegisterDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private final String namespace="com.cen.mapper.MemberMapper";
	
	
	@Override
	public void register(MemberVO vo) throws Exception {
		log.info("RegisterDAOImpl:: public void register(MemberVO vo) invoked!!!");
		sqlSession.insert(namespace+ ".registerMember", vo);		
	}//register
	
	

}//end class
