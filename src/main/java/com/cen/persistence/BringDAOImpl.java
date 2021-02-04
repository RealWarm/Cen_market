package com.cen.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cen.domain.MainVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class BringDAOImpl implements BringDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace="com.cen.mapper.BringMapper";
			
	@Override
	public List<MainVO> mainListAll() throws Exception {	
		log.info("BringDAOImpl:: mainListAll() invoked!!!");
		return session.selectList(namespace+".mainListAll");
	}//mainListAll

}//endclass
