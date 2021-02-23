package com.cen.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class ImageUpload {
	
	public String uploadFile(String uploadPath, String originalName, byte[] fileData) throws IOException {
		
		UUID uid = UUID.randomUUID();		
		String savedName = uid.toString() + "_" + originalName;		
		File target = new File(uploadPath, savedName);
		
		FileCopyUtils.copy(fileData, target);		
		
		return savedName; 
	}//uploadFile
	

}//endclass
