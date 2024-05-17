package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.designer.PostDesignerBoardCommentRequestDto;
import com.back.back.dto.request.designer.PostDesignerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;

public interface DesignerBoardService {
    ResponseEntity<ResponseDto> postDesignerBoard(PostDesignerBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> postDesignerBoardComment(PostDesignerBoardCommentRequestDto dto, int designerBoardNumber);
}
