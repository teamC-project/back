package com.back.back.dto.request.designer;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDesignerBoardImageRequestDto {
    
    private MultipartFile file;
}
