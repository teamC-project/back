package com.back.back.dto.response.trendboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.TrendBoardEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.util.ChangeDateFormatUtil;

import lombok.Getter;

@Getter
public class GetTrendBoardResponseDto extends ResponseDto {
	
	private Integer trendBoardNumber;

	private String trendBoardTitle;

	private String trendBoardContents;

	private String trendBoardWriterId;

	private String trendBoardWriteDateTime;

	private Integer trendBoardLikeCount;
	
	private Integer trendBoardViewCount;

	private GetTrendBoardResponseDto(TrendBoardEntity trendBoardEntity ) throws Exception {

		super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		this.trendBoardNumber = trendBoardEntity.getTrendBoardNumber();
		this.trendBoardTitle = trendBoardEntity.getTrendBoardTitle();
		this.trendBoardContents = trendBoardEntity.getTrendBoardContents();
		this.trendBoardWriterId = trendBoardEntity.getTrendBoardWriterId();
		this.trendBoardWriteDateTime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(trendBoardEntity.getTrendBoardWriteDatetime());;
		this.trendBoardLikeCount = trendBoardEntity.getTrendBoardLikeCount();
		this.trendBoardViewCount = trendBoardEntity.getTrendBoardViewCount();
	}

	public static ResponseEntity <GetTrendBoardResponseDto> success (TrendBoardEntity trendBoardEntity) throws Exception {

		GetTrendBoardResponseDto responseBody = new GetTrendBoardResponseDto(trendBoardEntity);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	
}
