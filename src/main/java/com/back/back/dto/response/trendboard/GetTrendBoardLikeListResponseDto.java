package com.back.back.dto.response.trendboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.LikeEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;


@Getter
public class GetTrendBoardLikeListResponseDto extends ResponseDto {
	
	private List<String> likeList;

	private GetTrendBoardLikeListResponseDto(String code, String message, List<LikeEntity> likeEntities) {
		
		super(code, message);
		List<String> likeList = new ArrayList<>();
		for (LikeEntity likeEntity: likeEntities)  likeList.add(likeEntity.getUserId());
		this.likeList = likeList;
	}

	public static ResponseEntity<GetTrendBoardLikeListResponseDto> success(List<LikeEntity> likeEntities) {

		GetTrendBoardLikeListResponseDto responseBody = new GetTrendBoardLikeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, likeEntities);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}

}
