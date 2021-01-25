package com.cen.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cen.domain.MemberVO;
import com.cen.model.LoginDTO;
import com.cen.persistence.member.LoginDAO;
import com.cen.persistence.member.RegisterDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {
	
	@Inject
	private RegisterDAO registerdao;
	
	@Inject
	private LoginDAO logindao;
	
	@Test
	public void testRegister() throws Exception{
		MemberVO vo = new MemberVO("testid2", "test2", "testname2", "testnick2", 
								   "test2@naver.com", "010-9999-9199", 1 , "관악구신림동");
		registerdao.register(vo);
	}//testCreate
	
	@Test
	public void testLogin() throws Exception{
		LoginDTO dto = new LoginDTO("testid", "test");
		Boolean bool = logindao.login(dto);		
		log.info("MemberDAOTest :: public void testLogin() invoked!!!"+" >>>>> ");
		if(bool==true) {
			log.info("login ok!!!!!");
		}else {
			log.info("login fail!!");
		}//if	
	}//testRead
	
	@Test
	public void testUpdate() throws Exception{
		
	}//testUpdate
	
	@Test
	public void testDelete() throws Exception{
		
	}//testDelete

}//end
