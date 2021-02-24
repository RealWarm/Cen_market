package com.cen.service;

import com.cen.domain.SboardVO;
import com.cen.model.SaleRegisterDTO;
import com.cen.model.ViewDTO;

public interface SaleService {
	
	// 최대의 게시글 번호를 말해준다.
	public int boardCnt() throws Exception;
	
	// 게시글을 삽입한다.
	public void insertBoard(SaleRegisterDTO dto) throws Exception; 
	
	// 이미지 데이터를 테이블에 삽입한다.
	public void insertImage(ViewDTO dto) throws Exception;
	
	// 나의 소속기관을 가져온다.
	public String getOrgName(String id) throws Exception;
	
	// 나의 최근 거래지역을 가져온다.
	public String getRecentAddress(String id) throws Exception;
	
	// 나의 최근 거래지역을 업대이트한다.
	public void updateRecentAddress(String id, String recent_address) throws Exception;

	// 게시글의 정보를 없데이트 한다.
	public void updateSaleBorad(SboardVO vo) throws Exception;

}//end interface
