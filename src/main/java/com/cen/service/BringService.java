package com.cen.service;

import java.util.List;

import com.cen.domain.MainVO;
import com.cen.domain.SboardVO;
import com.cen.domain.ViewVO;

public interface BringService {

	// 메인페이지에 최근 데이터를 가져온다.
	public List<MainVO> mainListAll() throws Exception;
	
	// 게시글 번호에 맞는  게시글을 가져옵니다.
	public SboardVO detail(Integer num) throws Exception;
	
	// 게시글에 속한 사진들의 목록을 모두 가져옵니다.
	public List<ViewVO> viewAll(Integer num) throws Exception;
	
}//end interface
