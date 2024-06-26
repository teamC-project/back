package com.back.back.service.implementation;

import java.io.File;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import com.back.back.service.DesignerBoardImageService;

@Service
public class DesignerBoardImageServiceImplementaion implements DesignerBoardImageService {

    @Value("${file.url}")
	private String fileUrl;

	@Value("${file.path}")
	private String filePath;

    @Override
    public String upload(MultipartFile file) {

        if (file.isEmpty()) return null;

			String originalFileName = file.getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
			String uuid = UUID.randomUUID().toString();
			String saveFileName = uuid + extension;
			String savePath = filePath + saveFileName;
		try {
			file.transferTo(new File(savePath));

		} catch(Exception exception) {
			exception.printStackTrace();
			return null;
		}
		
		String url = fileUrl + saveFileName;
		return url;
    }

    @Override
    public Resource getFile(String fileName) {

        Resource resource = null;

		try {
			resource = new UrlResource("file:" + filePath + fileName);

		} catch(Exception exception) {
			exception.printStackTrace();
			return null;
		}
		return resource;
    }

}
