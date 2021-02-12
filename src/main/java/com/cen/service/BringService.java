package com.cen.service;

import java.util.List;

import com.cen.domain.MainVO;
import com.cen.domain.ReplyVO;
import com.cen.domain.SboardVO;
import com.cen.domain.ViewVO;

public interface BringService {

	// 메인페이지에 최근 데이터를 가져온다.
	public List<MainVO> mainListAll() throws Exception;
	
	// 게시글 번호에 맞는  게시글을 가져옵니다.
	public SboardVO detail(Integer num) throws Exception;
	
	// 게시글 번호 하나가 주어졌을때 게시글의 대표이미지 하나 가져오기
	public String topPicture(Integer num) throws Exception;
	
	// 게시글에 속한 사진들의 목록을 모두 가져옵니다.
	public List<ViewVO> viewAll(Integer num) throws Exception;
	
	// 게시글의 댓글들을 모두 가져온다.
	public List<ReplyVO> replyAll(Integer rnum) throws Exception;
	
}//end interface
