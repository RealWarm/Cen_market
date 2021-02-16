package com.cen.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookMarkVO {
	
	private String sb_num;
	private String sb_name;
	private String sb_nickname;
	private String sb_writer; 
	private String Total_price; 
	private String trade_progress;	

}//end class
