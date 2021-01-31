package com.cen.model;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRegisterDTO {
	
//	sb_num varchar(150) not null,				/* 게시글 번호 해쉬를 이용한 인조키 */
//  sb_writer varchar(50) not null,  			/* 작성자의 아이디(FK) */
//  sb_name varchar(50) not null,  				/* 게시글의 제목 */
//  sb_detail varchar(2000) not null, 			/* 판매상품의 설명 */
//  -- peice_price int(50) not null,			/* 낱개 가격 */
//  Total_price int(50) not null,				/* 총 판매 금액 */ 
//  Total_quantity int(50) not null,			/* 총 판매수량 */
//	sb_regdate timestamp default now(),			/* 게시글 등록일 */
//  ct_num int(50) not null,					/* 카테고리 번호(FK) */
//  trade_shape	varchar(50) not null,			/* 거래 형태 */
//  trade_progress varchar(50) not null,		/* 거래 진행 상황 */
//  uploadFiles
	
	private int sb_num;				/* 게시글 번호 해쉬를 이용한 인조키 */
	private String sb_writer; 		/* 작성자의 아이디(FK) */
	private String sb_name;  		/* 게시글의 제목 */
	private String sb_detail;		/* 판매상품의 설명 */
    
    private int Total_price;		/* 총 판매 금액 */ 
    private int Total_quantity;		/* 총 판매수량 */
	private Timestamp sb_regdate;	/* 게시글 등록일 */
    private int ct_num;				/* 카테고리 번호(FK) */
    private String trade_shape;		/* 거래 형태 */
    private String trade_progress;	/* 거래 진행 상황 */

}//end class
