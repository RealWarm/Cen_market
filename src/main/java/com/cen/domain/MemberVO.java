package com.cen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String email;
	private String phnum;
	private int org_code;
	private String recent_address;
	

}//end class
