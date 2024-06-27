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

import com.back.back.dto.response.ResponseDto;
import com.back.back.service.TrendBoardService;
import com.back.back.dto.request.trend.PutTrendBoardRequestDto;
import com.back.back.dto.request.trend.PostTrendBoardRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardCommentRequestDto;
import com.back.back.dto.response.trendboard.GetTrendBoardResponseDto;
import com.back.back.dto.request.trend.PostTrendBoardCommentRequestDto;
import com.back.back.dto.response.trendboard.GetTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardLikeListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardCommentListResponseDto;
import com.back.back.dto.response.trendboard.GetSearchTrendBoardListResponseDto;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/service/trend_board")
@RequiredArgsConstructor
public class TrendBoardController {

    private final TrendBoardService trendBoardService;

    @GetMapping("/")
    public ResponseEntity<? super GetTrendBoardListResponseDto> getTrendBoardList() {
            ResponseEntity<? super GetTrendBoardListResponseDto> response = trendBoardService.getTrendBoardList();
        return response;
    }

    @GetMapping("/search")
    public ResponseEntity<? super GetSearchTrendBoardListResponseDto> getSearchTrendBoardList(
        @RequestParam("word") String word
        ) {
            ResponseEntity<? super GetSearchTrendBoardListResponseDto> response = trendBoardService.getSearchTrendBoardList(word);
        return response;
    }

    @GetMapping("/{trendBoardNumber}")
    public ResponseEntity<? super GetTrendBoardResponseDto> getTrendBoard(
        @PathVariable("trendBoardNumber") int trendBoardNumber
        ) {
            ResponseEntity<? super GetTrendBoardResponseDto> response = trendBoardService.getTrendBoard(trendBoardNumber);
        return response;
    }

    @GetMapping("/{trendBoardNumber}/comment/list")
    public ResponseEntity<? super GetTrendBoardCommentListResponseDto> getTrendBoardCommentList(
        @PathVariable("trendBoardNumber") int trendBoardNumber
        ) {
            ResponseEntity<? super GetTrendBoardCommentListResponseDto> response = trendBoardService.getTrendBoardCommentList(trendBoardNumber);
        return response;
    }

    @GetMapping("/{trendBoardNumber}/like_list") 
	public ResponseEntity< ? super GetTrendBoardLikeListResponseDto> getTrendBoardLikeList(
        @PathVariable("trendBoardNumber") Integer trendBoardNumber
        ) {
            ResponseEntity< ? super GetTrendBoardLikeListResponseDto> response = trendBoardService.getTrendBoardLikeList(trendBoardNumber);
        return response;
	}

    @PostMapping("/write")
    public ResponseEntity<ResponseDto> postTrendBoard(
        @RequestBody @Valid PostTrendBoardRequestDto requestBody,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = trendBoardService.postTrendBoard(requestBody, userId);
        return response;
    }

    @PostMapping("/{trendBoardNumber}/comment")
    public ResponseEntity<ResponseDto> postTrendBoardComment(
        @RequestBody @Valid PostTrendBoardCommentRequestDto requestBody,
        @PathVariable("trendBoardNumber") int trendBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = trendBoardService.postTrendBoardComment(requestBody, trendBoardNumber, userId);
        return response;
    }

    @PutMapping("/{trendBoardNumber}")
    public ResponseEntity<ResponseDto> putTrendBoard(
        @RequestBody @Valid PutTrendBoardRequestDto requestBody,
        @PathVariable("trendBoardNumber") int trendBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = trendBoardService.putTrendBoard(requestBody, trendBoardNumber, userId);
        return response;
    }

    @PutMapping("/{trendBoardCommentNumber}/comment")
    public ResponseEntity<ResponseDto> putTrendBoardComment(
        @RequestBody @Valid PutTrendBoardCommentRequestDto requestBody,
        @PathVariable("trendBoardCommentNumber") int trendBoardCommentNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = trendBoardService.putTrendBoardComment(requestBody, trendBoardCommentNumber, userId);
        return response;
    }

	@PutMapping("/{trendBoardNumber}/like")
	public ResponseEntity <? super ResponseDto> putTrendBoardLike (
        @PathVariable("trendBoardNumber") Integer trendBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity <? super ResponseDto> response = trendBoardService.putTrendBoardLike(trendBoardNumber, userId);
        return response;
	}

	@PatchMapping("/{trendBoardNumber}/increase_view_count")
	public ResponseEntity<ResponseDto> increaseTrendBoardViewCount (
        @PathVariable("trendBoardNumber") int trendBoardNumber
        ) {
            ResponseEntity <ResponseDto> response = trendBoardService.increaseTrendBoardViewCount(trendBoardNumber);
        return response;
	}

    @DeleteMapping("/{trendBoardNumber}")
    public ResponseEntity<ResponseDto> deleteTrendBoard(
        @PathVariable("trendBoardNumber") int trendBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = trendBoardService.deleteTrendBoard(trendBoardNumber, userId);
        return response;
    }

    @DeleteMapping("/{trendBoardCommentNumber}/comment")
    public ResponseEntity<ResponseDto> deleteTrendBoardComment(
        @PathVariable("trendBoardCommentNumber") int trendBoardCommentNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = trendBoardService.deleteTrendBoardComment(trendBoardCommentNumber, userId);
        return response;
    }

	
    @DeleteMapping("/{trendBoardNumber}/like_list")
	public ResponseEntity<ResponseDto> deleteTrendBoardLikeList(
        @PathVariable("trendBoardNumber") int trendBoardNumber
        ) {
            ResponseEntity<ResponseDto> response = trendBoardService.deleteTrendBoardLikeList(trendBoardNumber);
        return response;
	}

}