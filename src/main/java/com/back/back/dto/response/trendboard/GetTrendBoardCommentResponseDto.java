package com.back.back.dto.response.trendboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.dto.response.trendboard.GetTrendBoardCommentResponseDto;
import com.back.back.entity.TrendBoardCommentEntity;

import lombok.Getter;

@Getter
public class GetTrendBoardCommentResponseDto extends ResponseDto {
	    private Integer trendBoardCommentNumber;
    private String trendBoardCommentWriterId;
    private String trendBoardCommentWriteDatetime;
    private String trendBoardCommentContents;
    
    private GetTrendBoardCommentResponseDto (TrendBoardCommentEntity trendBoardCommentEntity) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        String trendCommentWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDD(trendBoardCommentEntity.getTrendBoardCommentWriteDatetime());

        this.trendBoardCommentNumber = trendBoardCommentEntity.getTrendBoardCommentNumber();
        this.trendBoardCommentWriterId = trendBoardCommentEntity.getTrendBoardCommentWriterId();
        this.trendBoardCommentWriteDatetime = trendCommentWriteDatetime;
        this.trendBoardCommentContents = trendBoardCommentEntity.getTrendBoardCommentContents();
    }

    public static ResponseEntity<GetTrendBoardCommentResponseDto> success (TrendBoardCommentEntity trendBoardCommentEntity) throws Exception {
        GetTrendBoardCommentResponseDto responseBody = new GetTrendBoardCommentResponseDto(trendBoardCommentEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
