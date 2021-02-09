package com.cen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewDTO {
	// 입력으로 들어온 사진을 DB에 넣기위한 빈클래스	
	private int sb_num;				// 게시글 번호	
	private String view_name;		// 확장자 포함한, 이미지 이름	
}//endclass
