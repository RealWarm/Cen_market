package com.cen.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.cen.domain.MemberVO;
import com.cen.persistence.MypageDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MypageServiceImpl implements MypageService{
	
	@Inject
	MypageDAO dao;
	
	@Override
	public void updateProgress(String sb_num, String trade_progress) throws Exception {
		log.info("MypageServiceImpl :: updateProgress() invoked!!");
		dao.updateProgress(sb_num, trade_progress);
	}//updatePorgress

	@Override
	public void deleteBoard(String sb_num) throws Exception {
		log.info("MypageServiceImpl :: deleteBoard() invoked!!");
		dao.deleteBoard(sb_num);
	}//deleteBoard

	@Override
	public void deleteBook(String sb_num, String sb_writer) throws Exception {
		log.info("MypageServiceImpl :: deleteBook() invoked!!");
		dao.deleteBook(sb_num, sb_writer);
	}//deleteBook

	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		log.info("MypageServiceImpl :: memberUpdate() invoked!!");
		System.out.println("@@@@ MypageServiceImpl vo : " + vo);
		dao.memberUpdate(vo);
	}//memberUpdate

	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		log.info("MypageServiceImpl :: memberUpdate() invoked!!");
		dao.memberDelete(vo);
	}//memberDelete

}//end-class
