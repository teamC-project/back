package com.back.back.dto.response.customerboard;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.CustomerBoardEntity;

import lombok.Getter;

@Getter
public class GetCustomerBoardResponseDto extends ResponseDto {
    private Integer customerBoardNumber;
    private String customerBoardTitle;
    private String customerBoardContents;
    private String customerBoardWriterId;
    private String customerBoardWriteDatetime;
    private Integer customerBoardViewCount;
    private Boolean isSecret;
    // private Integer customerBoardCommentCount;

    private GetCustomerBoardResponseDto(CustomerBoardEntity customerBoardEntity) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        String customerWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(customerBoardEntity.getCustomerBoardWriteDatetime());

        this.customerBoardNumber = customerBoardEntity.getCustomerBoardNumber();
        this.customerBoardTitle = customerBoardEntity.getCustomerBoardTitle();
        this.customerBoardWriterId = customerBoardEntity.getCustomerBoardWriterId();
        this.customerBoardWriteDatetime = customerWriteDatetime;
        this.customerBoardViewCount = customerBoardEntity.getCustomerBoardViewCount();
        // this.customerBoardCommentCount = customerBoardEntity.getCustomerBoardCommentCount();
        this.customerBoardContents = customerBoardEntity.getCustomerBoardContents();
        this.isSecret = customerBoardEntity.getSecret();
    }

    public static ResponseEntity<GetCustomerBoardResponseDto> success(CustomerBoardEntity customerBoardEntity) throws Exception {
        GetCustomerBoardResponseDto responseBody = new GetCustomerBoardResponseDto(customerBoardEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }


}
