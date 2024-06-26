package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.request.qna.PutQnaBoardRequestDto;
import com.back.back.dto.request.qna.PostQnaBoardRequestDto;
import com.back.back.dto.response.qnaboard.GetQnaBoardResponseDto;
import com.back.back.dto.request.qna.PostQnaBoardCommentRequestDto;
import com.back.back.dto.response.qnaboard.GetQnaBoardListResponseDto;
import com.back.back.dto.response.qnaboard.GetSearchQnaBoardListResponseDto;

public interface QnaBoardService {
    
    ResponseEntity<ResponseDto> increaseQnaViewCount(int qnaBoardNumber);
    ResponseEntity<ResponseDto> deleteQnaBoard(int qnaBoardNumber, String userId);
    ResponseEntity<ResponseDto> postQnaBoard(PostQnaBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> putQnaBoard(PutQnaBoardRequestDto dto, int qnaBoardNumber, String userId);
    ResponseEntity<ResponseDto> postQnaBoardComment(PostQnaBoardCommentRequestDto dto, int receptionNumber);

    ResponseEntity<? super GetQnaBoardListResponseDto> getQnaBoardList();
    ResponseEntity<? super GetQnaBoardResponseDto> getQnaBoard(int qnaBoardNumber);
    ResponseEntity<? super GetSearchQnaBoardListResponseDto> getSearchQnaBoardList(String searchWord);
    
}
