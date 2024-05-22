package com.back.back.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.back.back.service.FileControllService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class FileController {
		private final FileControllService fileControllService;

	@PostMapping("/upload") 
	public String upload(
		@RequestParam("file") MultipartFile file
	) {
		String url = fileControllService.upload(file);
		return url;
	}

	@GetMapping(value="/file/{fileName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public Resource getFile(
		@PathVariable("fileName") String fileName
	) {
		Resource resource = fileControllService.getFile(fileName);
		return resource;
	}
}
