package com.cen.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class MypageDAOImpl implements MypageDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private final String namespace="com.cen.mapper.InfoMapper";

	@Override
	public void updateProgress(String sb_num, String trade_progress) throws Exception {
		log.info("MypageDAOImpl :: updatePorgress() invoiked!!");
		Map<String, String> upMap=new HashMap<>();
		upMap.put("sb_num", sb_num);
		upMap.put("trade_progress", trade_progress);
		System.out.println("@@@@@@@@@@@ " + upMap);
		sqlSession.update(namespace + ".updatePorgress", upMap);
	}//updatePorgress

	@Override
	public void deleteBoard(String sb_num) throws Exception {
		log.info("MypageDAOImpl :: deleteBoard() invoiked!!");
		sqlSession.delete(namespace+".deleteBoard", sb_num);
	}//deleteBoard

	@Override
	public void deleteBook(String sb_num, String sb_writer) throws Exception {
		log.info("MypageDAOImpl :: deleteBook() invoiked!!");
		Map<String, String> upMap=new HashMap<>();
		upMap.put("sb_num", sb_num);
		upMap.put("sb_writer", sb_writer);
		System.out.println("@@@@@@@@@@@ " + upMap);
		sqlSession.delete(namespace+".deleteBook", upMap);
	}//deleteBook
	
	

}//end-class
