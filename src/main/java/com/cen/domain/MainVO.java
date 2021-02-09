package com.cen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainVO {
	// 메인, 상세페이지에 보여주기 위한 이미지 데이터를 가져오기 위한 VO	
	private int sb_num;				// 게시글 번호
	private String sb_name;			// 게시글 제목
	private String sb_detail;		// 게시글 상세내용
	private String sb_view;			// 대표이미지
	private String Total_price;		// 가격
	private String trade_area;		// 거래지역
	
}//end class
