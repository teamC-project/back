package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.back.back.service.QnaBoardService;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.request.qna.PutQnaBoardRequestDto;
import com.back.back.dto.request.qna.PostQnaBoardRequestDto;
import com.back.back.dto.response.qnaboard.GetQnaBoardResponseDto;
import com.back.back.dto.request.qna.PostQnaBoardCommentRequestDto;
import com.back.back.dto.response.qnaboard.GetQnaBoardListResponseDto;
import com.back.back.dto.response.qnaboard.GetSearchQnaBoardListResponseDto;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/qna_board")
@RequiredArgsConstructor
public class QnaBoardController {

    private final QnaBoardService qnaBoardService;

    @GetMapping("/")
    public ResponseEntity<? super GetQnaBoardListResponseDto> getBoardList() {
            ResponseEntity<? super GetQnaBoardListResponseDto> response = qnaBoardService.getQnaBoardList();
        return response;
    }

    @GetMapping("/search")
    public ResponseEntity<? super GetSearchQnaBoardListResponseDto> getSearchBoardList(
        @RequestParam("word") String word
        ) {
            ResponseEntity<? super GetSearchQnaBoardListResponseDto> response = qnaBoardService.getSearchQnaBoardList(word);
        return response;
    }

    @GetMapping("/{qnaBoardNumber}")
    public ResponseEntity<? super GetQnaBoardResponseDto> getQnaBoard(
        @PathVariable("qnaBoardNumber") int qnaBoardNumber
        ) {
            ResponseEntity<? super GetQnaBoardResponseDto> response = qnaBoardService.getQnaBoard(qnaBoardNumber);
        return response;
    }

    @PostMapping("/write")
    public ResponseEntity<ResponseDto> postQnaBoard(
        @RequestBody @Valid PostQnaBoardRequestDto requestBody,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = qnaBoardService.postQnaBoard(requestBody, userId);
        return response;
    }

    @PostMapping("/{qnaBoardNumber}/comment")
    public ResponseEntity<ResponseDto> postQnaBoardComment(
        @RequestBody @Valid PostQnaBoardCommentRequestDto requestBody,
        @PathVariable("qnaBoardNumber") int receptionNumber) {
            ResponseEntity<ResponseDto> response = qnaBoardService.postQnaBoardComment(requestBody, receptionNumber);
        return response;
    }

    @PutMapping("/{qnaBoardNumber}")
    public ResponseEntity<ResponseDto> putQnaBoard(
        @RequestBody @Valid PutQnaBoardRequestDto requestBody,
        @PathVariable("qnaBoardNumber") int receptionNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = qnaBoardService.putQnaBoard(requestBody, receptionNumber, userId);
        return response;
    }


    @PatchMapping("/{qnaBoardNumber}/increase_view_count")
    public ResponseEntity<ResponseDto> increaseQnaViewCount(
        @PathVariable("qnaBoardNumber") int qnaBoardNumber
        ) {
            ResponseEntity<ResponseDto> response = qnaBoardService.increaseQnaViewCount(qnaBoardNumber);
        return response;
    }

    @DeleteMapping("/{qnaBoardNumber}")
    public ResponseEntity<ResponseDto> deleteQnaBoard(
        @PathVariable("qnaBoardNumber") int qnaBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = qnaBoardService.deleteQnaBoard(qnaBoardNumber, userId);
        return response;
    }

}
