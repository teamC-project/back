package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.dto.request.designer.PostDesignerBoardCommentRequestDto;
import com.back.back.dto.request.designer.PostDesignerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.service.DesignerBoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/designer_board")
@RequiredArgsConstructor
public class DesignerBoardController {

    private final DesignerBoardService designerBoardService;

    @PostMapping("/")
    ResponseEntity<ResponseDto> postDesignerBoard (
        @RequestBody @Valid PostDesignerBoardRequestDto requestBody,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = designerBoardService.postDesignerBoard(requestBody, userId);
        return response;
    }

    @PostMapping("/{designBoardNumber}/comment")
    public ResponseEntity<ResponseDto> postDesignerBoardComment (
        @RequestBody @Valid PostDesignerBoardCommentRequestDto requestBody,
        @PathVariable("designerBoardNumber") int designerBoardNumber
    ) {
        ResponseEntity<ResponseDto> response = designerBoardService.postDesignerBoardComment(requestBody, designerBoardNumber);
        return response;
    }
}
