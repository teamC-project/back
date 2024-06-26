package com.back.back.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface TrendBoardImageService {

	String upload(MultipartFile file);
	
	Resource getFile(String fileName);

}
