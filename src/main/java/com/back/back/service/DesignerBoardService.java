package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.request.designer.PutDesignerBoardRequestDto;
import com.back.back.dto.request.designer.PostDesignerBoardRequestDto;
import com.back.back.dto.request.designer.PutDesignerBoardCommentRequestDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardResponseDto;
import com.back.back.dto.request.designer.PostDesignerBoardCommentRequestDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardListResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardCommentResponseDto;
import com.back.back.dto.response.designerboard.GetSearchDesignerBoardListResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardCommentListResponseDto;

public interface DesignerBoardService {

    ResponseEntity<ResponseDto> increaseViewCount(int designerBoardNumber);
    ResponseEntity<ResponseDto> deleteDesignerBoard(int designerBoardNumber, String userId);
    ResponseEntity<ResponseDto> postDesignerBoard(PostDesignerBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> deleteDesignerBoardComment(int designerBoardCommentNumber, String userId);
    ResponseEntity<ResponseDto> putDesignerBoard(PutDesignerBoardRequestDto dto, int designerBoardNumber, String userId);
    ResponseEntity<ResponseDto> postDesignerBoardComment(PostDesignerBoardCommentRequestDto dto, int designerBoardNumber, String userId);
    ResponseEntity<ResponseDto> putDesignerBoardComment(PutDesignerBoardCommentRequestDto dto, int designerBoardCommentNumber, String userId);
    
    ResponseEntity<? super GetDesignerBoardListResponseDto> getDesignerBoardList();
    ResponseEntity<? super GetSearchDesignerBoardListResponseDto> getSearchDesignerBoardList(String searchWord);
    ResponseEntity<? super GetDesignerBoardResponseDto> getDesignerBoard(int designerBoardNumber, String userId);
    ResponseEntity<? super GetDesignerBoardCommentResponseDto> getDesignerBoardComment(int designerBoardCommentNumber);
    ResponseEntity<? super GetDesignerBoardCommentListResponseDto> getDesignerBoardCommentList(int designerBoardNumber);

}
