package com.cen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO {
	
	private String ct_num;		/* 카테고리번호 */
	private String ct_main;		/* 대 분 류 */
	private String ct_middle;	/* 중 분 류 */
	private String ct_sub;		/* 소 분 류 */	
	
}//end class
