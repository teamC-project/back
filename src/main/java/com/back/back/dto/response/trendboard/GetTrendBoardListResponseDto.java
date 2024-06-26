package com.back.back.dto.response.trendboard;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.TrendBoardEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.object.TrendBoardListItem;

import lombok.Getter;

@Getter
public class GetTrendBoardListResponseDto extends ResponseDto {

	private List<TrendBoardListItem> trendBoardList;

	private GetTrendBoardListResponseDto(List<TrendBoardEntity> trendBoardEntities	) throws Exception {
		
		super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		this.trendBoardList = TrendBoardListItem.getTrendBoardList(trendBoardEntities);
    }

    public static ResponseEntity<GetTrendBoardListResponseDto>success(List<TrendBoardEntity> trendBoardEntities) throws Exception {

		GetTrendBoardListResponseDto responseBody = new GetTrendBoardListResponseDto(trendBoardEntities);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	
}
