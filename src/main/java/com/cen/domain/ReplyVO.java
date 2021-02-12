package com.cen.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
	
	private Integer rp_num; 		/* 댓글 인조키 */
	private Integer sb_num; 		/* 게시글 번호를 정수로 */
	private String sb_writer; 		/* 작성자의 아이디(FK) */
	private String sb_nickname; 	/* 작성자의 닉네임 */
	private String sb_detail; 		/* 판매상품의 설명 */
	private Timestamp rp_regdate; 	/* 댓글 등록일 */	

}//end class
