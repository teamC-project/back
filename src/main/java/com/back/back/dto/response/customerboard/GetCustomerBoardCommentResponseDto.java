package com.back.back.dto.response.customerboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.CustomerBoardCommentEntity;

import lombok.Getter;

@Getter
public class GetCustomerBoardCommentResponseDto extends ResponseDto {
    
    private Integer customerBoardCommentNumber;
    private String customerBoardCommentContents;
    private String customerBoardCommentWriterId;
    private String customerBoardCommentWriteDatetime;

    private GetCustomerBoardCommentResponseDto (CustomerBoardCommentEntity customerBoardCommentEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.customerBoardCommentNumber = customerBoardCommentEntity.getCustomerBoardCommentNumber();
        this.customerBoardCommentContents = customerBoardCommentEntity.getCustomerBoardCommentContents();
        this.customerBoardCommentWriterId = customerBoardCommentEntity.getCustomerBoardCommentWriterId();
        this.customerBoardCommentWriteDatetime =  ChangeDateFormatUtil.changeYYYYMMDDHHMM(customerBoardCommentEntity.getCustomerBoardCommentWriteDatetime());
    }

    public static ResponseEntity<GetCustomerBoardCommentResponseDto> success (CustomerBoardCommentEntity customerBoardCommentEntity) throws Exception {

        GetCustomerBoardCommentResponseDto responseBody = new GetCustomerBoardCommentResponseDto(customerBoardCommentEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
