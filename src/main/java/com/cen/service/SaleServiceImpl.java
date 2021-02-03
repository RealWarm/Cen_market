package com.cen.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

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

}//end class




