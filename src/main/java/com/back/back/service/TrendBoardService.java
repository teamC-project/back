package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.trend.PostTrendBoardCommentRequestDto;
import com.back.back.dto.request.trend.PostTrendBoardRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardCommentRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.trendboard.GetSearchTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardResponseDto;



public interface TrendBoardService {
ResponseEntity<ResponseDto> postTrendBoard(PostTrendBoardRequestDto dto, String userId);
ResponseEntity<ResponseDto> postTrendBoardComment(
	PostTrendBoardCommentRequestDto requestBody, int trendBoardNumber, String userId
);
ResponseEntity <? super GetTrendBoardListResponseDto> getTrendBoardList();
ResponseEntity< ? super GetSearchTrendBoardListResponseDto> getSearchTrendBoardList(String trendBoardSearchWord);
ResponseEntity <? super GetTrendBoardResponseDto> getTrendBoard(int trendBoardNumber);
ResponseEntity<ResponseDto> putTrendBoard(PutTrendBoardRequestDto dto, int trendBoardNumber, String userId);
ResponseEntity<ResponseDto> putTrendBoardComment(PutTrendBoardCommentRequestDto dto, int trendBoardCommentNumber, String userId);
ResponseEntity<ResponseDto> deleteTrendBoard(int trendBoardNumber , String userId );
ResponseEntity<ResponseDto> deleteTrendBoardComment(int trendBoardCommentNumber, String userId);
ResponseEntity<ResponseDto> increaseTrendBoardLikeCount(int trendBoardNumber);
ResponseEntity<ResponseDto> decreaseTrendBoardLikeCount(int trendBoardNumber);
};
