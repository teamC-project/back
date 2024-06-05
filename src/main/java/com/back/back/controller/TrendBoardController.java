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

import com.back.back.dto.request.trend.PostTrendBoardCommentRequestDto;
import com.back.back.dto.request.trend.PostTrendBoardRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardCommentRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.trendboard.GetSearchTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardResponseDto;
import com.back.back.service.TrendBoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/service/trend_board")
@RequiredArgsConstructor
public class TrendBoardController {

	private final TrendBoardService trendBoardService;

	@PostMapping("/write") 
	ResponseEntity<ResponseDto> postTrendBoard (
		@RequestBody @Valid PostTrendBoardRequestDto requestBody,
		@AuthenticationPrincipal String userId 
	) {
		ResponseEntity<ResponseDto> response = trendBoardService.postTrendBoard(requestBody, userId);
		return response;
	}
	

	@PostMapping("/{trendBoardNumber}/comment")
    public ResponseEntity<ResponseDto> postTrendBoardComment (
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
    public ResponseEntity<ResponseDto> putTrendBoardComment (
        @RequestBody @Valid PutTrendBoardCommentRequestDto requestBody,
        @PathVariable("trendBoardCommentNumber") int trendBoardCommentNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = trendBoardService.putTrendBoardComment(requestBody, trendBoardCommentNumber, userId);
        return response;
    }

	@GetMapping("/") 
	public ResponseEntity< ? super GetTrendBoardListResponseDto> 
	getTrendBoardList() {
		ResponseEntity<? super GetTrendBoardListResponseDto> response = trendBoardService.getTrendBoardList();

		return response;
	}

	@GetMapping("/search") 
	public ResponseEntity< ? super GetSearchTrendBoardListResponseDto> getSearchBoardList(
		@RequestParam("word") String word	) {
			ResponseEntity< ? super GetSearchTrendBoardListResponseDto> response = trendBoardService.getSearchTrendBoardList(word);

			return response;
		}

		@GetMapping("/{trendBoardNumber}") 
		public ResponseEntity <? super GetTrendBoardResponseDto> getTrendBoard( 
			@PathVariable("trendBoardNumber") int trendBoardNumber
		) {
			ResponseEntity<? super GetTrendBoardResponseDto> response = trendBoardService.getTrendBoard(trendBoardNumber);
			return response;
		}

		@PatchMapping("/{trendBoardNumber}/increase_trend_like_count")
		public ResponseEntity<ResponseDto> increaseTrendLikeCount (
			@PathVariable("trendBoardNumber") int trendBoardNumber
		) {
			ResponseEntity<ResponseDto> response = trendBoardService.increaseTrendBoardLikeCount(trendBoardNumber);
			return response;
		}

		@PatchMapping("/{trendBoardNumber}/decrease_trend_like_count")
		public ResponseEntity<ResponseDto> decreaseTrendLikeCount (
			@PathVariable("trendBoardNumber") int trendBoardNumber
		) {
			ResponseEntity<ResponseDto> response = trendBoardService.decreaseTrendBoardLikeCount(trendBoardNumber);
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
    public ResponseEntity<ResponseDto> deleteTrendBoardComment (
        @PathVariable("trendBoardCommentNumber") int trendBoardCommentNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response =  trendBoardService.deleteTrendBoardComment(trendBoardCommentNumber, userId);
        return response;
    }
}
