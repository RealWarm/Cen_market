package com.cen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewVO {
		
	private Integer sb_num;			/* 게시글 번호 */
	private String view_name;		/* 사진이름 */

}//end class
