package com.cen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewDTO {
	
	
//	sb_num varchar(50) not null,		/* 게시글 번호 */
//  view_name varchar(50) not null,		/* 사진이름 */
	
//	private String sb_num;
	private int sb_num;
	private String view_name;
	
	
}//endclass
