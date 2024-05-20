package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.qna.PostQnaBoardRequestDto;
import com.back.back.dto.response.ResponseDto;

public interface QnaBoardService {
  ResponseEntity<ResponseDto> postQnaBoard(PostQnaBoardRequestDto dto , String userId);
}
