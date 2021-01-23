package com.cen.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cen.domain.BoardVO;
import com.cen.persistence.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("user01");
		dao.create(board);		
		
	}//testCreate
	
	@Test
	public void testRead() throws Exception{
		log.info(dao.read(1).toString());
	}//testRead
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO bd = new BoardVO();
		bd.setBno(1);
		bd.setTitle("수정된 글입니다.");
		bd.setContent("수정테스트");
		dao.update(bd);		
	}//testUpdate
	
	@Test
	public void testDelete() throws Exception{
		dao.delete(1);
	}//testDelete

}//end
