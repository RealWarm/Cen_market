package com.cen.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cen.domain.MemberVO;
import com.cen.persistence.MypageDAO;
import com.cen.service.MypageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyPageDAOTest {

	@Inject
	MypageDAO dao;
	
	@Inject
	MypageService service;
	
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
	
	@Test
	public void testmemberUpdate() throws Exception{
		log.info("MyPageDAOTest :: testmemberUpdate() invoked!!!!!!!"); 
		MemberVO vo=new MemberVO();
		vo.setId("start");
		vo.setEmail("11111@naver.com");
		vo.setNickname("111111");
		vo.setOrg_name("1111");
		vo.setPhnum("010-1111-0000");
		vo.setPassword("b2938805d70faeffb2446698ebabc6c1c33e06a90d966e815ab58b72716eb3cb");
		System.out.println(vo);
		dao.memberUpdate(vo);
	}//test
	
	@Test
	public void testServicememberUpdate() throws Exception{
		log.info("MyPageDAOTest :: testmemberUpdate() invoked!!!!!!!"); 
		MemberVO vo=new MemberVO();
		vo.setId("start");
		vo.setEmail("33333@naver.com");
		vo.setNickname("3333");
		vo.setOrg_name("3333");
		vo.setPhnum("010-3333-0000");
		vo.setPassword("b2938805d70faeffb2446698ebabc6c1c33e06a90d966e815ab58b72716eb3cb");
		System.out.println(vo);
		service.memberUpdate(vo);
	}//test
	
	@Test
	public void testdeleteMember() throws Exception{
		MemberVO vo=new MemberVO();
		vo.setId("start");		
		vo.setPassword("b2938805d70faeffb2446698ebabc6c1c33e06a90d966e815ab58b72716eb3cb");
		vo.setName("startname");
		dao.memberDelete(vo);
	}//test

	
}//end-class
