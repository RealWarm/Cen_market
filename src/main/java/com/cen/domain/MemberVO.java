package com.cen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String email;
	private String phnum;
	private String org_name;
	private String recent_address;
	

}//end class
