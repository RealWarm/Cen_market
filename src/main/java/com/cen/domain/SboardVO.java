package com.cen.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//	sb_num int(50) not null auto_increment,		/* 게시글 번호를 정수로 */
//	sb_writer varchar(50) not null,  			/* 작성자의 아이디(FK) */
//	sb_nickname varchar(20) not null,			/* 작성자의 닉네임 */
//	sb_name varchar(50) not null,  				/* 게시글의 제목 */
//	sb_detail varchar(2000) not null, 			/* 판매상품의 설명 */
//	
//	Total_price int(50) not null,				/* 총 판매 금액 */ 
//	Total_quantity int(50) not null,			/* 총 판매수량 */
//	sb_regdate timestamp default now(),			/* 게시글 등록일 */
//	ct_num int(50) not null,					/* 카테고리 번호(FK) */
//	trade_shape	varchar(50) not null,			/* 거래 형태 */
//	trade_progress varchar(50) default "판매중",	/* 거래 진행 상황 */    
  

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SboardVO {
	
		private int sb_num; 			/* 게시글 번호를 정수로 */
		private String sb_writer;   	/* 작성자의 아이디(FK) */
		private String sb_nickname; 	/* 작성자의 닉네임 */
		private String sb_name;			/* 게시글의 제목 */
		private String sb_detail;  		/* 판매상품의 설명 */		
		private int Total_price; 		/* 총 판매 금액 */ 
		private int Total_quantity; 	/* 총 판매수량 */
		private Timestamp sb_regdate; 	/* 게시글 등록일 */
		private int ct_num; 			/* 카테고리 번호(FK) */
		private String trade_shape;		/* 거래 형태 */
		private String trade_progress; 	/* 거래 진행 상황 */
			

}//end class



//sboard 테이블에 데이터를 집어넣고, 해당 게시글번호에 맞는 이지 이름들을 저장한다.
//private int sb_num;					/* 게시글 번호 해쉬를 이용한 인조키 */ 	>> 데이터베이스에서 번호를 가져온다은 넣는다.
//private String sb_writer; 			/* 작성자의 아이디(FK) */			>> 세션에서 추출한다.
//private String sb_name;  			/* 게시글의 제목 */				
//private String sb_detail;			/* 판매상품의 설명 */				 
//
//private int Total_price;			/* 총 판매 금액 */
//private int Total_quantity;			/* 총 판매수량 */
// private Timestamp sb_regdate;	/* 게시글 등록일 */				>> sysdate써서 지금의
//private int ct_num;					/* 카테고리 번호(FK) */
//private String trade_shape;			/* 거래 형태 */
//private String trade_progress;		/* 거래 진행 상황 */				>> "판매중"으로 초기화
// private String recent_address;	// 발송주소					>>

// 이미지 이름을 데이터베이스에 넣는다.
// 서비스 만들기 
// 1. 데이터베이스 게시글 갯수 세는 서비스 >> 추후에 암호화도 가능할거같음 
// 2. 게시글을 데이터베이스에 넣는다.
// 3. 이미지들을 데이터베이스에 넣는다.


























