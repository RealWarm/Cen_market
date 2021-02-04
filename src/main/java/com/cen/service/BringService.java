package com.cen.service;

import java.util.List;

import com.cen.domain.MainVO;

public interface BringService {

	// 메인페이지에 최근 데이터를 가져온다.
		public List<MainVO> mainListAll() throws Exception;
	
}//end interface
