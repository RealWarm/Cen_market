package com.cen.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cen.domain.BookMarkVO;
import com.cen.domain.CategoryVO;
import com.cen.domain.MainVO;
import com.cen.domain.ReplyVO;
import com.cen.domain.SboardVO;
import com.cen.domain.ViewVO;

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

	@Override
	public SboardVO detail(Integer num) throws Exception {
		log.info("BringDAOImpl:: detail(Integer num) invoked!!!");
		return session.selectOne(namespace + ".sdetail", num);
	}//detail
	
	@Override
	public String topPicture(Integer num) throws Exception {
		log.info("BringDAOImpl:: topPicture(Integer num) invoked!!!");
		return session.selectOne(namespace + ".bringTop", num);
	}//topPicture

	@Override
	public List<ViewVO> viewAll(Integer num) throws Exception {		
		log.info("BringDAOImpl:: viewAll(Integer num) invoked!!!");
		return session.selectList(namespace+".bringViewAll", num);
	}//viewAll

	@Override
	public List<ReplyVO> replyAll(Integer rnum) throws Exception {
		log.info("BringDAOImpl:: mainListAll() invoked!!!");		
		return session.selectList(namespace+".bringReply", rnum);
	}//replyAll

	@Override
	public List<SboardVO> bringSaling(String sb_writer) throws Exception {
		log.info("BringDAOImpl:: bringSaling() invoked!!!");	
		return session.selectList(namespace+".bringSaling", sb_writer);
	}//bringSaling

	@Override
	public List<SboardVO> bringSaleComplete(String sb_writer) throws Exception {
		log.info("BringDAOImpl:: bringSaleComplete() invoked!!!");
		return session.selectList(namespace+".bringSaleComplete", sb_writer);
	}//bringSaleComplete

	@Override
	public List<BookMarkVO> bringBookMark(String sb_writer) throws Exception {
		log.info("BringDAOImpl:: bringBookMark() invoked!!!");
		return session.selectList(namespace+".bringBookMark", sb_writer);
	}//bringBookMark

	
	// 카테고리 분류페이지.
	@Override
	public List<MainVO> cateListAll(String ct_num) throws Exception {
		log.info("BringDAOImpl:: cateListAll() invoked!!!");
		return session.selectList(namespace+".bringCategory", ct_num);
	}//cateListAll

	@Override
	public CategoryVO categoryData(String ct_num) throws Exception {
		log.info("BringDAOImpl:: cateListAll() invoked!!!");
		return session.selectOne(namespace+".bringCateData", ct_num);
	}

	
}//endclass
