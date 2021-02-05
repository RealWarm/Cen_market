package com.cen.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cen.domain.MainVO;
import com.cen.persistence.BringDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BringDAOTest {
	
	@Inject
	BringDAO dao;
	
	@Test
	public void testMainAll() throws Exception {
		log.info("BringDAOTest::testMainAll invoked!!");
		List<MainVO> list=dao.mainListAll();
		
		for(MainVO vv : list) {
			log.info("게시글번호 : "+ vv.getSb_num());
			log.info("게시글제목 : "+ vv.getSb_name());
			log.info("게시글상세 : "+ vv.getSb_detail());
			log.info("게시글사진 : "+ vv.getSb_view());
			log.info("=====================================");
		}//for-vv
		
	}//test
	
	
	

}//endclass
