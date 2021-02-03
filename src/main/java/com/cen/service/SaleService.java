package com.cen.service;

import com.cen.model.SaleRegisterDTO;
import com.cen.model.ViewDTO;

public interface SaleService {
	
	// 최대의 게시글 번호를 말해준다.
	public int boardCnt() throws Exception;
	
	// 게시글을 삽입한다.
	public void insertBoard(SaleRegisterDTO dto) throws Exception; 
	
	// 이미지 데이터를 테이블에 삽입한다.
	public void insertImage(ViewDTO dto) throws Exception;
	

}//end interface
