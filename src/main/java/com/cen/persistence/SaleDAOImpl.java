package com.cen.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cen.model.SaleRegisterDTO;
import com.cen.model.ViewDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class SaleDAOImpl implements SaleDAO {

	@Inject
	private SqlSession sqlSession;
	
	private final String namespace="com.cen.mapper.saleMapper";
	
	
	@Override
	public int boardCnt() throws Exception {
		log.info("SaleDAOImpl::public int boardCnt() invked!!!");
		int cnt=sqlSession.selectOne(namespace+".getBoardCnt");
		return cnt;
	}//boardCnt

	@Override
	public void insertBoard(SaleRegisterDTO dto) throws Exception {
		log.info("SaleDAOImpl::public void insertBoard(SaleRegisterDTO dto) invked!!!");
		sqlSession.insert(namespace+".insertBoard", dto);
	}//insertBoard

	@Override
	public void insertImage(ViewDTO dto) throws Exception {
		log.info("SaleDAOImpl::public void insertImage(ViewDTO dto) invked!!!");
		sqlSession.insert(namespace+".insertImage", dto);
	}//insertImage

}//end class










