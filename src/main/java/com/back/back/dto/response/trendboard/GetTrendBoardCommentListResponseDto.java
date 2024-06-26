package com.back.back.dto.response.trendboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.TrendBoardCommentEntity;
import com.back.back.common.object.TrendBoardCommentListItem;

import lombok.Getter;

@Getter
public class GetTrendBoardCommentListResponseDto extends ResponseDto {

    private List<TrendBoardCommentListItem> trendBoardCommentList;

    public GetTrendBoardCommentListResponseDto(List<TrendBoardCommentEntity> trendBoardCommentEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.trendBoardCommentList = TrendBoardCommentListItem.getList(trendBoardCommentEntities);
    }

    public static ResponseEntity<GetTrendBoardCommentListResponseDto> success(List<TrendBoardCommentEntity> trendBoardCommentEntities)throws Exception {

        GetTrendBoardCommentListResponseDto responseBody = new GetTrendBoardCommentListResponseDto(trendBoardCommentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
