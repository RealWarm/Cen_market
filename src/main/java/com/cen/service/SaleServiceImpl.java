package com.cen.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.cen.domain.SboardVO;
import com.cen.model.SaleRegisterDTO;
import com.cen.model.ViewDTO;
import com.cen.persistence.SaleDAO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class SaleServiceImpl implements SaleService{
	
	@Inject
	SaleDAO saledao;

	@Override
	public int boardCnt() throws Exception {	
		log.info("SaleServiceImpl:: boardCnt() invoked!!");
		return saledao.boardCnt();
	}//boardCnt

	@Override
	public void insertBoard(SaleRegisterDTO dto) throws Exception {
		log.info("SaleServiceImpl:: insertBoard() invoked!!");
		saledao.insertBoard(dto);
	}//insertBoard

	@Override
	public void insertImage(ViewDTO dto) throws Exception {
		log.info("SaleServiceImpl:: insertImage() invoked!!");
		saledao.insertImage(dto);
	}//insertImage

	@Override
	public String getOrgName(String id) throws Exception {
		log.info("SaleServiceImpl:: getOrgName() invoked!!");
		return saledao.getOrgName(id);
	}//getOrgName

	@Override
	public String getRecentAddress(String id) throws Exception {
		log.info("SaleServiceImpl:: getRecentAddress() invoked!!");
		return saledao.getRecentAddress(id);
	}//getRecentAddress

	@Override
	public void updateRecentAddress(String id, String recent_address) throws Exception {
		log.info("SaleServiceImpl:: updateRecentAddress() invoked!!");
		saledao.updateRecentAddress(id, recent_address);
	}//updateRecentAddress

	@Override
	public void updateSaleBorad(SboardVO vo) throws Exception {
		log.info("SaleServiceImpl:: updateSaleBorad() invoked!!");
		saledao.updateSaleBorad(vo);
	}//updateSaleBorad

}//end class




