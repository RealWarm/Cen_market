package com.cen.persistence;

import com.cen.model.SaleRegisterDTO;
import com.cen.model.ViewDTO;

public interface SaleDAO {
	
	// 게시글의 갯수를 가져온다.
	public int boardCnt() throws Exception;
	
	// 게시글을 삽입한다.
	public void insertBoard(SaleRegisterDTO dto) throws Exception; 
	
	// 이미지 데이터를 테이블에 삽입한다.
	public void insertImage(ViewDTO dto) throws Exception;
	

}//saleDAO
