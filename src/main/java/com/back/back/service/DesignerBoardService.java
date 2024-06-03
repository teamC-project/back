package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.designer.PostDesignerBoardCommentRequestDto;
import com.back.back.dto.request.designer.PostDesignerBoardRequestDto;
import com.back.back.dto.request.designer.PutDesignerBoardCommentRequestDto;
import com.back.back.dto.request.designer.PutDesignerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardCommentListResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardCommentResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardListResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardResponseDto;
import com.back.back.dto.response.designerboard.GetSearchDesignerBoardListResponseDto;

public interface DesignerBoardService {
    ResponseEntity<ResponseDto> postDesignerBoard(PostDesignerBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> postDesignerBoardComment(PostDesignerBoardCommentRequestDto dto, int designerBoardNumber, String userId);

    ResponseEntity<? super GetDesignerBoardListResponseDto> getDesignerBoardList();
    ResponseEntity<? super GetSearchDesignerBoardListResponseDto> getSearchDesignerBoardList(String searchWord);
    ResponseEntity<? super GetDesignerBoardResponseDto> getDesignerBoard(int designerBoardNumber);
    ResponseEntity<? super GetDesignerBoardCommentListResponseDto> getDesignerBoardCommentList();
    ResponseEntity<? super GetDesignerBoardCommentResponseDto> getDesignerBoardComment(int designerBoardCommentNumber);

    ResponseEntity<ResponseDto> putDesignerBoard(PutDesignerBoardRequestDto dto, int designerBoardNumber, String userId);
    ResponseEntity<ResponseDto> putDesignerBoardComment(PutDesignerBoardCommentRequestDto dto, int designerBoardCommentNumber, String userId);

    ResponseEntity<ResponseDto> deleteDesignerBoard(int designerBoardNumber, String userId);
    ResponseEntity<ResponseDto> deleteDesignerBoardComment(int designerBoardCommentNumber, String userId);

    ResponseEntity<ResponseDto> increaseViewCount(int designerBoardNumber);
}
