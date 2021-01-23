package com.cen.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cen.domain.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace="com.cen.mapper.BoardMapper";
	
	
	@Override
	public void create(BoardVO vo) throws Exception {
		log.info("BoardDAOImpl :: create(BoardVO vo) invoked!!");
		session.insert(namespace + ".create", vo);
	}//create

	@Override
	public BoardVO read(Integer bno) throws Exception {
		log.info("BoardDAOImpl :: read(Integer bno) invoked!!");		
		return session.selectOne(namespace + ".read", bno);
	}//read

	@Override
	public void update(BoardVO vo) throws Exception {
		log.info("BoardDAOImpl :: update(BoardVO vo) invoked!!");	
		session.update(namespace + ".update", vo);
	}//update

	@Override
	public void delete(Integer bno) throws Exception {
		log.info("BoardDAOImpl :: delete(Integer bno) invoked!!");	
		session.delete(namespace+".delete", bno);
	}//delete

	@Override
	public List<BoardVO> listAll() throws Exception {	
		log.info("BoardDAOImpl :: listAll() invoked!!");
		return session.selectList(namespace+".listAll");
	}//listAll

}//end
