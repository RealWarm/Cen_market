package com.cen.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cen.domain.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class FindDAOImpl implements FindDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.cen.mapper.FindMapper";

	@Override
	public String findId(MemberVO vo) throws Exception {
		log.info("FindDAOImpl :: findId() invoked!!");
		return sqlSession.selectOne(namespace+".findId", vo);
	}//findId

	@Override
	public String findPw(MemberVO vo) throws Exception {
		log.info("FindDAOImpl :: findPw() invoked!!");
		return sqlSession.selectOne(namespace+".findPw", vo);		
	}//findPw
	
	@Override
	public void updatePw(MemberVO vo) throws Exception {
		log.info("FindDAOImpl :: updatePw() invoked!!");
		sqlSession.update(namespace+".updatePw", vo);
	}//updatePw	

}//end class





