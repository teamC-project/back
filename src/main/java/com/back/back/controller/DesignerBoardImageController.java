package com.back.back.controller;

import org.springframework.http.MediaType;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.service.DesignerBoardImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/designer_board")
@RequiredArgsConstructor
public class DesignerBoardImageController {
    
    private final DesignerBoardImageService designerBoardImageService;

    @GetMapping(value="/file/{fileName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public Resource getFile(
		@PathVariable("fileName") String fileName
		) {
		Resource resource = designerBoardImageService.getFile(fileName);
		return resource;
	}
	
	@PostMapping("/upload")
	public String upload(
		@RequestParam("file") MultipartFile file
		) {
		String url = designerBoardImageService.upload(file);
		return url;
	}

}