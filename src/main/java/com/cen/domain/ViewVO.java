package com.cen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//	sb_num int(50) not null,			/* 게시글 번호 */
//	view_name varchar(50) not null,		/* 사진이름 */   


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewVO {
		
	private Integer sb_num;			/* 게시글 번호 */
	private String view_name;		/* 사진이름 */

}//end class
