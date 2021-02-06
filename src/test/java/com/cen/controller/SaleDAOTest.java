package com.cen.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cen.model.SaleRegisterDTO;
import com.cen.model.ViewDTO;
import com.cen.persistence.SaleDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SaleDAOTest {

	@Inject
	private SaleDAO saledao;
	
	@Test
	public void testGetBoardCnt() throws Exception{
		int cnt=saledao.boardCnt();
		System.out.println(cnt);
	}//testCreate
	
	@Test
	public void testinsertBoard() throws Exception{
//		SaleRegisterDTO dto = new SaleRegisterDTO(2, "testid1", "사무용 책상 팝니다.",  "사무용 의자 책상팝니다. ㅇㅇㅇㅇ팝니다. ㅇㅇㅇㅇ팝니다. ㅇㅇㅇㅇ팝니다. ㅇㅇㅇㅇ",
//				100000, 1, 110, "직거래", "main_banner11_1200x350.png");
//		System.out.println(dto);
//		saledao.insertBoard(dto);		
	}//testCreate
	
	
	@Test
	public void testinsertImage() throws Exception{
		ViewDTO dto = new ViewDTO(2222, "cat.jpg");
		saledao.insertImage(dto);
	}//testCreate
	
	
}//end class
