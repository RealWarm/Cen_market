package com.cen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.cen.domain.MainVO;
import com.cen.domain.ReplyVO;
import com.cen.domain.SboardVO;
import com.cen.domain.ViewVO;
import com.cen.persistence.BringDAO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class BringServiceImpl implements BringService{
	
	@Inject
	BringDAO dao;

	@Override
	public List<MainVO> mainListAll() throws Exception {		
		log.info("BringServiceImpl::mainListAll invoked!!");
		return dao.mainListAll();
	}//mainListAll

	@Override
	public SboardVO detail(Integer num) throws Exception {
		log.info("BringServiceImpl::detail invoked!!");
		return dao.detail(num);
	}//detail
	
	@Override
	public String topPicture(Integer num) throws Exception {
		log.info("BringServiceImpl::topPicture(Integer num) invoked!!");
		return dao.topPicture(num);
	}//topPicture

	@Override
	public List<ViewVO> viewAll(Integer num) throws Exception {
		log.info("BringServiceImpl::viewAll invoked!!");
		return dao.viewAll(num);
	}//viewAll

	@Override
	public List<ReplyVO> replyAll(Integer rnum) throws Exception {
		log.info("BringServiceImpl::replyAll(Integer rnum) invoked!!");
		return dao.replyAll(rnum);
	}//replyAll

	

}//end class
