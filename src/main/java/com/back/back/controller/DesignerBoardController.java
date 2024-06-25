package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.dto.request.designer.PostDesignerBoardCommentRequestDto;
import com.back.back.dto.request.designer.PostDesignerBoardRequestDto;
import com.back.back.dto.request.designer.PutDesignerBoardCommentRequestDto;
import com.back.back.dto.request.designer.PutDesignerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardCommentListResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardListResponseDto;
import com.back.back.dto.response.designerboard.GetSearchDesignerBoardListResponseDto;
import com.back.back.service.DesignerBoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/designer_board")
@RequiredArgsConstructor
public class DesignerBoardController {

    private final DesignerBoardService designerBoardService;

    @PostMapping("/")
    ResponseEntity<ResponseDto> postDesignerBoard(
        @RequestBody @Valid PostDesignerBoardRequestDto requestBody,
        @AuthenticationPrincipal String userId
        ) {
        ResponseEntity<ResponseDto> response = designerBoardService.postDesignerBoard(requestBody, userId);
        return response;
    }

    @PostMapping("/{designerBoardNumber}/comment")
    public ResponseEntity<ResponseDto> postDesignerBoardComment(
        @RequestBody @Valid PostDesignerBoardCommentRequestDto requestBody,
        @PathVariable("designerBoardNumber") int designerBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
        ResponseEntity<ResponseDto> response = designerBoardService.postDesignerBoardComment(requestBody,
        designerBoardNumber, userId);
        return response;
    }

    @GetMapping("/list")
    public ResponseEntity<? super GetDesignerBoardListResponseDto> getDesignerBoardList() {
        ResponseEntity<? super GetDesignerBoardListResponseDto> response = designerBoardService.getDesignerBoardList();
        return response;
    }

    @GetMapping("/list/search")
    public ResponseEntity<? super GetSearchDesignerBoardListResponseDto> getSearchDesingerBoardList(
        @RequestParam("word") String word
        ) {
        ResponseEntity<? super GetSearchDesignerBoardListResponseDto> response = designerBoardService
        .getSearchDesignerBoardList(word);
        return response;
    }

    @GetMapping("/{designerBoardNumber}")
    public ResponseEntity<? super GetDesignerBoardResponseDto> getDesignerBoard(
        @PathVariable("designerBoardNumber") int designerBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
        return designerBoardService.getDesignerBoard(designerBoardNumber, userId);
    }

    @GetMapping("/{designerBoardNumber}/comment/list")
    public ResponseEntity<? super GetDesignerBoardCommentListResponseDto> getDesignerBoardCommentList(
        @PathVariable("designerBoardNumber") int designerBoardNumber
        ) {
        ResponseEntity<? super GetDesignerBoardCommentListResponseDto> response = designerBoardService
        .getDesignerBoardCommentList(designerBoardNumber);
        return response;
    }

    @PutMapping("/{designerBoardNumber}")
    public ResponseEntity<ResponseDto> putDesignerBoard(
        @RequestBody @Valid PutDesignerBoardRequestDto requestBody,
        @PathVariable("designerBoardNumber") int designerBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
        ResponseEntity<ResponseDto> response = designerBoardService.putDesignerBoard(requestBody, designerBoardNumber,
        userId);
        return response;
    }

    @PutMapping("/{designerBoardCommentNumber}/comment")
    public ResponseEntity<ResponseDto> putDesignerBoardComment(
        @RequestBody @Valid PutDesignerBoardCommentRequestDto requestBody,
        @PathVariable("designerBoardCommentNumber") int designerBoardCommentNumber,
        @AuthenticationPrincipal String userId
        ) {
        ResponseEntity<ResponseDto> response = designerBoardService.putDesignerBoardComment(requestBody,
        designerBoardCommentNumber, userId);
        return response;
    }

    @DeleteMapping("/{designerBoardNumber}")
    public ResponseEntity<ResponseDto> deleteDesignerBoard(
        @PathVariable("designerBoardNumber") int designerBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
        ResponseEntity<ResponseDto> response = designerBoardService.deleteDesignerBoard(designerBoardNumber, userId);
        return response;
    }

    @DeleteMapping("/{designerBoardCommentNumber}/comment")
    public ResponseEntity<ResponseDto> deleteDesignerBoardComment(
        @PathVariable("designerBoardCommentNumber") int designerBoardCommentNumber,
        @AuthenticationPrincipal String userId
        ) {
        ResponseEntity<ResponseDto> response = designerBoardService.deleteDesignerBoardComment(designerBoardCommentNumber,
        userId);
        return response;
    }

    @PatchMapping("/{designerBoardNumber}/increase-view-count")
    public ResponseEntity<ResponseDto> increaseViewCount(
        @PathVariable("designerBoardNumber") int designerBoardNumber
        ) {
        ResponseEntity<ResponseDto> response = designerBoardService.increaseViewCount(designerBoardNumber);
        return response;
    }
}