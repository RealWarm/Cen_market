package com.cen.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
	
	private String sb_writer; 		/* 작성자의 아이디(FK) */
	private String sb_nickname; 	/* 작성자의 닉네임 */
	private Integer sb_num; 		/* 게시글 번호를 정수로 */
	private String sb_detail; 		/* 판매상품의 설명 */		

}//end class