package com.back.back.dto.response.loginlog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetVisitorsTodayResponseDto extends ResponseDto {

    private Integer visitorsToday;

    public GetVisitorsTodayResponseDto(Integer visitorsToday) {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.visitorsToday = visitorsToday;
    }

    public static ResponseEntity<GetVisitorsTodayResponseDto> success(Integer visitorsToday) {
        
        GetVisitorsTodayResponseDto responseBody = new GetVisitorsTodayResponseDto(visitorsToday);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
