package com.cen.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cen.domain.MemberVO;
import com.cen.model.LoginDTO;
import com.cen.persistence.LoginDAO;
import com.cen.persistence.RegisterDAO;

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
		LoginDTO dto = new LoginDTO("testid1", "test");
		MemberVO vo = logindao.login(dto);		
		log.info("MemberDAOTest :: public void testLogin() invoked!!!");
		System.out.println(vo);
		
		if(vo!=null) {
			log.info("login ok!!!!!");
		}else {
			log.info("login fail!!");
		}//if	
	}//testRead
	
	@Test
	public void testgetOrgCodeNum() throws Exception{
		log.info("MemberDAOTest :: public void testgetOrgCodeNum() invoked!!!");
		String str = new String("신림동 동사무서");
		int res=registerdao.find_OrgCode(str);
		log.info("코드넘버는 " + res + " 입니다.");
	}//testUpdate
	
	@Test
	public void testfind_OrgAddress() throws Exception{
		log.info("MemberDAOTest :: public void testfind_OrgAddress() invoked!!!");
		String str = registerdao.find_OrgAddress(1);
		System.out.println("주소는 " + str + " 입니다.");
	}//testDelete
	
	@Test
	public void testfind_id() throws Exception{
		log.info("MemberDAOTest :: public void testfind_id() invoked!!!");
		int res = registerdao.idCheck("testid2");
		if(res==1) {
			System.out.println("아이디가 있습니다.");
		}else if(res==0) {
			System.out.println("아이디가 없습니다.");
		}//if
	}//testfind_id
	
	
	@Test
	public void testfind_nick() throws Exception{
		log.info("MemberDAOTest :: public void testfind_nick() invoked!!!");
		int res = registerdao.nickCheck("testnick2");
		if(res==1) {
			System.out.println("아이디가 있습니다.");
		}else if(res==0) {
			System.out.println("아이디가 없습니다.");
		}//if
	}//testDelete
	
	
	@Test
	public void testfind_email() throws Exception{
		log.info("MemberDAOTest :: public void testfind_email() invoked!!!");
		int res = registerdao.emailCheck("test2@naver.com");
		if(res==1) {
			System.out.println("아이디가 있습니다.");
		}else if(res==0) {
			System.out.println("아이디가 없습니다.");
		}//if
	}//testfind_email
	
	
	
	

}//end
