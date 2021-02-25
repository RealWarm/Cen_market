package com.cen.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cen.domain.MemberVO;
import com.cen.persistence.FindDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AuthDAOTest {
	
	@Inject
	FindDAO dao;
	
	@Test
	public void testfindId() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setName("정훈");
		vo.setEmail("wjd@naver.com");
		String id = dao.findId(vo);
		System.out.println("id :: " + id);
	}//testCreate
	
	@Test
	public void testfindPW() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setId("real123");
		vo.setEmail("wjd@naver.com");
		String pw = dao.findPw(vo);
		System.out.println("id :: " + pw);
	}//testCreate

	@Test
	public void testUpdatePW() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setId("real123");
		vo.setEmail("wjd@naver.com");
		vo.setPassword("b2938805d70faeffb2446698ebabc6c1c33e06a90d966e815ab58b72716eb3cb");
		dao.updatePw(vo);
		
	}//testUpdatePW
	
}//end class
