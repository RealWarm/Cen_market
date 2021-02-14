package com.cen.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cen.domain.MemberVO;
import com.cen.model.ReplyDTO;

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
	
	@Override
	public void registReply(ReplyDTO dto) throws Exception {
		log.info("RegisterDAOImpl:: public String registReply(ReplyVO vo) invoked!!!");
		sqlSession.insert(namespace + ".registReply", dto);
	}//registReply

	//=================== 형식검사==============================
	@Override
	public int idCheck(String user_id) throws Exception {
		log.info("RegisterDAOImpl:: public String find_OrgAddress(int org_code) invoked!!!");
		return sqlSession.selectOne(namespace + ".idCheck", user_id);
	}//idCheck

	@Override
	public int nickCheck(String user_nick) throws Exception {
		log.info("RegisterDAOImpl:: public int nickCheck(String user_nick) invoked!!!");
		return sqlSession.selectOne(namespace + ".nickCheck", user_nick);
	}//nickCheck
	

	@Override
	public int emailCheck(String user_email) throws Exception {
		log.info("RegisterDAOImpl:: public int emailCheck(String user_email) invoked!!!");		
		return sqlSession.selectOne(namespace + ".emailCheck", user_email);
	}//emailCheck


	@Override
	public void bookMark(String sb_num, String sb_writer) throws Exception {
		log.info("RegisterDAOImpl:: public void bookMark(int sb_num, String sb_writer) invoked!!!");
		Map<String, String> bmk = new HashMap<>();
		bmk.put("sb_num", sb_num);
		bmk.put("sb_writer", sb_writer);
		sqlSession.insert(namespace + ".bookMark", bmk);
	}//bookMark


	@Override
	public void deleteBookMark(String sb_num, String sb_writer) throws Exception {		
		log.info("RegisterDAOImpl:: public void deleteBookMark(String sb_num, String sb_writer) invoked!!!");
		Map<String, String> bmk = new HashMap<>();
		bmk.put("sb_num", sb_num);
		bmk.put("sb_writer", sb_writer);
		sqlSession.delete(namespace + ".deleteBookMark", bmk);
	}//deleteBookMark


	@Override
	public int getbookCnt(String sb_num, String sb_writer) throws Exception {
		log.info("RegisterDAOImpl:: public int getbookCnt(String sb_num, String sb_writer) invoked!!!");
		Map<String, String> bmk = new HashMap<>();
		bmk.put("sb_num", sb_num);
		bmk.put("sb_writer", sb_writer);		
		return sqlSession.selectOne(namespace + ".getBookCnt", bmk);
	}//getbookCnt


	


	
	

}//end class
