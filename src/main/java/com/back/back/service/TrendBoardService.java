package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.trend.PostTrendBoardCommentRequestDto;
import com.back.back.dto.request.trend.PostTrendBoardRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardCommentRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.trendboard.GetSearchTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardCommentListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardCommentResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardLikeListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardResponseDto;
import com.back.back.dto.response.trendboard.PutLikeResponseDto;

public interface TrendBoardService {
<<<<<<< HEAD

    ResponseEntity<ResponseDto> postTrendBoard(PostTrendBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> postTrendBoardComment(PostTrendBoardCommentRequestDto dto, int trendBoardNumber, String userId);
    ResponseEntity<ResponseDto> putTrendBoard(PutTrendBoardRequestDto dto, int trendBoardNumber, String userId);
    ResponseEntity<ResponseDto> putTrendBoardComment(PutTrendBoardCommentRequestDto dto, int trendBoardCommentNumber, String userId);
    ResponseEntity<ResponseDto> deleteTrendBoard(int trendBoardNumber , String userId );
    ResponseEntity <ResponseDto> deleteTrendBoardComment(int trendBoardCommentNumber, String userId);
    ResponseEntity <ResponseDto> deleteTrendBoardLikeList(int trendBoardNumber);
    ResponseEntity<ResponseDto> increaseTrendBoardViewCount(int trendBoardNumber);
    
=======
    ResponseEntity<ResponseDto> postTrendBoard(PostTrendBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> postTrendBoardComment(PostTrendBoardCommentRequestDto dto, int trendBoardNumber, String userId);
>>>>>>> c430ef6b1f8c23f3c951503c8b3025ca2245200a
    ResponseEntity <? super GetTrendBoardListResponseDto> getTrendBoardList();
    ResponseEntity< ? super GetTrendBoardCommentListResponseDto> getTrendBoardCommentList(int trendBoardNumber);
    ResponseEntity<? super GetTrendBoardCommentResponseDto> getTrendBoardComment(int trendBoardCommentNumber);
    ResponseEntity< ? super GetSearchTrendBoardListResponseDto> getSearchTrendBoardList(String trendBoardSearchWord);
<<<<<<< HEAD
    ResponseEntity <? super GetTrendBoardResponseDto> getTrendBoard(int trendBoardNumber);
    ResponseEntity <? super PutLikeResponseDto> putTrendBoardLike(Integer trendBoardNumber, String userId);
    ResponseEntity < ? super GetTrendBoardLikeListResponseDto> getTrendBoardLikeList(Integer trendBoardNumber);
=======
	ResponseEntity <? super GetTrendBoardResponseDto> getTrendBoard(int trendBoardNumber);
	ResponseEntity<ResponseDto> putTrendBoard(PutTrendBoardRequestDto dto, int trendBoardNumber, String userId);
	ResponseEntity<ResponseDto> putTrendBoardComment(PutTrendBoardCommentRequestDto dto, int trendBoardCommentNumber, String userId);
	ResponseEntity<ResponseDto> deleteTrendBoard(int trendBoardNumber , String userId );
	ResponseEntity <? super PutLikeResponseDto> putTrendBoardLike(Integer trendBoardNumber, String userId);
	ResponseEntity < ? super GetTrendBoardLikeListResponseDto> getTrendBoardLikeList(Integer trendBoardNumber);
	ResponseEntity <ResponseDto> deleteTrendBoardComment(int trendBoardCommentNumber, String userId);
	ResponseEntity <ResponseDto> deleteTrendBoardLikeList(int trendBoardNumber);
	ResponseEntity<ResponseDto> increaseTrendBoardViewCount(int trendBoardNumber);
>>>>>>> c430ef6b1f8c23f3c951503c8b3025ca2245200a
};
