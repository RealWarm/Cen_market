package com.cen.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cen.persistence.MypageDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyPageDAOTest {

	@Inject
	MypageDAO dao;
	
	@Test
	public void testupdatePorgress() throws Exception {
		String sb_num="1";
		String trade_progress="판매중";
		dao.updateProgress(sb_num, trade_progress);		
	}//test
	
	@Test
	public void testdeleteBoard() throws Exception{
		String sb_num="1";
		dao.deleteBoard(sb_num);
	}//test
	
	@Test
	public void testdeleteBook() throws Exception{
		String sb_num="1";
		String sb_writer="real123";
		dao.deleteBook(sb_num, sb_writer);
	}//test

	
}//end-class
