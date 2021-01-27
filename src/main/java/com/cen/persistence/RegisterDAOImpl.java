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
	
	
	@Override	// 회원등록
	public void register(MemberVO vo) throws Exception {
		log.info("RegisterDAOImpl:: public void register(MemberVO vo) invoked!!!");
		System.out.println(vo);
		sqlSession.insert(namespace+ ".registerMember", vo);		
	}//register


	@Override
	public int find_OrgCode(String org_name) throws Exception {
		log.info("RegisterDAOImpl:: public int find_OrgCode(String org_name) invoked!!!");
		int code = sqlSession.selectOne(namespace+ ".getOrgCode", org_name);
		log.info("org_num is " + code + " !!!!!!!!!!! ");
		return code;
	}//register


	@Override
	public String find_OrgAddress(int org_code) throws Exception {
		log.info("RegisterDAOImpl:: public String find_OrgAddress(int org_code) invoked!!!");
		String str = sqlSession.selectOne(namespace + ".getOrgAdderss", org_code);
		return str;
	}//find_OrgAddress
	
	

}//end class
