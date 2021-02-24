package com.cen.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cen.domain.SboardVO;
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
		Integer cnt=sqlSession.selectOne(namespace+".getBoardCnt");		
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

	@Override
	public String getOrgName(String id) throws Exception {
		log.info("SaleDAOImpl::public void getOrgName() invked!!!");
		String orgName=sqlSession.selectOne(namespace+".getOrgName", id);
		if(orgName==null) {
			orgName="";
		}//if
		return orgName;
	}//getOrgName

	@Override
	public String getRecentAddress(String id) throws Exception {
		log.info("SaleDAOImpl::public void getRecentAddress() invked!!!");
		String recentAddress=sqlSession.selectOne(namespace+".getRecentAddress", id);
		if(recentAddress==null) {
			recentAddress="";
		}//if
		return recentAddress;
	}//getRecentAddress

	@Override
	public void updateRecentAddress(String id, String recent_address) throws Exception {
		log.info("SaleDAOImpl::public void updateRecentAddress() invked!!!");
		Map<String, String> dMap = new HashMap<>();		
		dMap.put("id", id);
		dMap.put("recent_address", recent_address);
		sqlSession.update(namespace+".updateRecentAddress", dMap);
	}//updateRecentAddress

	@Override
	public void updateSaleBorad(SboardVO vo) throws Exception {
		log.info("SaleDAOImpl::public void updateRecentAddress() invked!!!");
		sqlSession.update(namespace+".updateSaleBorad", vo);
	}//updateSaleBorad

}//end class










