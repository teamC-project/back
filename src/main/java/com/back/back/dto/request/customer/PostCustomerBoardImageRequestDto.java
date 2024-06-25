package com.back.back.dto.request.customer;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCustomerBoardImageRequestDto {
    
    private MultipartFile file;
}
