package com.cen.service;

import java.util.List;

import com.cen.domain.BookMarkVO;
import com.cen.domain.CategoryVO;
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
	
	// 내가 등록한 게시글주 판매중인  게시글 가져오기
	public List<SboardVO> bringSaling(String sb_writer) throws Exception;
	
	// 내가 등록한 게시글중 판매완료인  게시글 가져오기
	public List<SboardVO> bringSaleComplete(String sb_writer) throws Exception;
	
	// 내가 찜 한 게시글 목록 정보들을 가져오기
	public List<BookMarkVO> bringBookMark(String sb_writer) throws Exception;
	
	// 선택한 카테고리에 따른 데이터를 가져온다. >> 상세카테고리 데이터
	public List<MainVO> cateListAll(String ct_num) throws Exception;
	
	// 카테고리의 정보를 가져온다.
	public CategoryVO categoryData(String ct_num) throws Exception;
	
}//end interface
