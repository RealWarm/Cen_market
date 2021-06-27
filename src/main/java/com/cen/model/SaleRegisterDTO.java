package com.cen.model;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRegisterDTO {
	// 게시글에서 등록한 이미지를 DB에 넣는 DTO
	// 게시글 수정을 위해서 DB에서 가져오기 위한 
	private int sb_num;					/* 게시글 번호 */ 				// 이미지를 저장하기위해서 게시글 번호가 필요하다. 
	private String sb_writer; 			/* 작성자의 아이디(FK) */			// 세션에서 끄내온다.
	private String sb_nickname;			/* 판매자의 닉네임 */				// 세션에서 끄내온다.
	private String sb_name;  			/* 게시글의 제목 */				// 
	private String sb_detail;			/* 판매상품의 설명 */				// 	
    private int Total_price;			/* 총 판매 금액 */
    private int Total_quantity;			/* 총 판매수량 */
    private int ct_num;					/* 카테고리 번호(FK) */			// 욕심 부리지말고 대분류를 나타내는 버튼만 만들어보자.
    private String trade_shape;			/* 거래 형태 */
    private String sb_view;				/* 게시글 대표 이미지(FK) */
//  private String recent_address;		// 최근 거래지역 >> 매번 자신의 최근 주소를 업데이트 한다.	
//	private Timestamp sb_regdate;		/* 게시글 등록일 */
//  private String trade_progress;		/* 거래 진행 상황 */     
    private String trade_area;			/* 거래희망 지역 */
    
}//end class



//sb_num varchar(150) not null,				/* 게시글 번호 해쉬를 이용한 인조키 */
//sb_writer varchar(50) not null,  			/* 작성자의 아이디(FK) */
//sb_name varchar(50) not null,  				/* 게시글의 제목 */
//sb_detail varchar(2000) not null, 			/* 판매상품의 설명 */
//-- peice_price int(50) not null,			/* 낱개 가격 */
//Total_price int(50) not null,				/* 총 판매 금액 */ 
//Total_quantity int(50) not null,			/* 총 판매수량 */
//sb_regdate timestamp default now(),			/* 게시글 등록일 */
//ct_num int(50) not null,					/* 카테고리 번호(FK) */
//trade_shape	varchar(50) not null,			/* 거래 형태 */
//trade_progress varchar(50) not null,		/* 거래 진행 상황 */
//uploadFiles