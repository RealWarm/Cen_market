package com.cen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainVO {
	
	private int sb_num;
	private String sb_name;
	private String sb_detail;
	private String sb_view;

}//end class
