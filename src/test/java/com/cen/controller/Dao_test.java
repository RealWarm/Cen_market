package com.cen.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class Dao_test {
	
	@Inject
	private DataSource ds;
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testConection() throws Exception {
		
		try(Connection con = ds.getConnection()){
				log.info("++++++ "+ con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//test
	
	@Test
	public void testFactory() {
		log.info("@@@@@@@@"+sqlFactory);
	}//testFactory
	
	@Test
	public void testSession() {
		try(SqlSession session=sqlFactory.openSession()){
			log.info("@@@@@@@@"+session);
		}catch(Exception e) {
			e.printStackTrace();
		}//try			
	}//testSession

}//end class

