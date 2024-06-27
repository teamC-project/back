package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.request.trend.PutTrendBoardRequestDto;
import com.back.back.dto.request.trend.PostTrendBoardRequestDto;
import com.back.back.dto.response.trendboard.GetTrendBoardResponseDto;
import com.back.back.dto.request.trend.PutTrendBoardCommentRequestDto;
import com.back.back.dto.request.trend.PostTrendBoardCommentRequestDto;
import com.back.back.dto.response.trendboard.GetTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardCommentResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardLikeListResponseDto;
import com.back.back.dto.response.trendboard.GetSearchTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardCommentListResponseDto;

public interface TrendBoardService {
	
	ResponseEntity<ResponseDto> deleteTrendBoardLikeList(int trendBoardNumber);
	ResponseEntity<ResponseDto> increaseTrendBoardViewCount(int trendBoardNumber);
	ResponseEntity<ResponseDto> deleteTrendBoard(int trendBoardNumber , String userId );
    ResponseEntity<ResponseDto> postTrendBoard(PostTrendBoardRequestDto dto, String userId);
	ResponseEntity<ResponseDto> deleteTrendBoardComment(int trendBoardCommentNumber, String userId);
	ResponseEntity<ResponseDto> putTrendBoard(PutTrendBoardRequestDto dto, int trendBoardNumber, String userId);
    ResponseEntity<ResponseDto> postTrendBoardComment(PostTrendBoardCommentRequestDto dto, int trendBoardNumber, String userId);
	ResponseEntity<ResponseDto> putTrendBoardComment(PutTrendBoardCommentRequestDto dto, int trendBoardCommentNumber, String userId);

	ResponseEntity<? super GetTrendBoardListResponseDto> getTrendBoardList();
	ResponseEntity<? super GetTrendBoardResponseDto> getTrendBoard(int trendBoardNumber);
	ResponseEntity<ResponseDto> putTrendBoardLike(Integer trendBoardNumber, String userId);
	ResponseEntity<? super GetTrendBoardLikeListResponseDto> getTrendBoardLikeList(Integer trendBoardNumber);
    ResponseEntity<? super GetTrendBoardCommentResponseDto> getTrendBoardComment(int trendBoardCommentNumber);
    ResponseEntity<? super GetTrendBoardCommentListResponseDto> getTrendBoardCommentList(int trendBoardNumber);
    ResponseEntity<? super GetSearchTrendBoardListResponseDto> getSearchTrendBoardList(String trendBoardSearchWord);

}
