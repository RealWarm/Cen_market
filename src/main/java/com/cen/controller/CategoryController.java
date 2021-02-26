package com.cen.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cen.domain.CategoryVO;
import com.cen.domain.MainVO;
import com.cen.service.BringService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Inject
	private BringService bringService;
	
	// 카테고리 상세페이
	// 대분류에 따른 카테고리 분류를 하고, 게시글들으 가져온다.
	@GetMapping("/greate")
	public String categoryGet(@RequestParam("ct_num") String ct_num, Model model) throws Exception {
		log.info("SaleController :: public void registGet() invoked!!!");
		List<MainVO> list1=bringService.cateListAll(ct_num);
		CategoryVO CData=bringService.categoryData(ct_num);
		for(MainVO vo:list1) {
			String[] sp = vo.getSb_view().split("_");
			vo.setSb_view(sp[1]);
			System.out.println(sp[1]);
		}//enhanced-for
		model.addAttribute("list1", list1);
		model.addAttribute("CData", CData);
		return "/category_details";
	}//categoryGet	

}//end class



