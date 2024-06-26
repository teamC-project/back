package com.back.back.dto.response.customerboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.CustomerBoardCommentEntity;
import com.back.back.common.object.CustomerBoardCommentListItem;

import lombok.Getter;

@Getter
public class GetCustomerBoardCommentListResponseDto extends ResponseDto {
    
    private List<CustomerBoardCommentListItem> customerBoardCommentList;

    private GetCustomerBoardCommentListResponseDto (List<CustomerBoardCommentEntity> customerBoardCommentEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.customerBoardCommentList = CustomerBoardCommentListItem.getList(customerBoardCommentEntities);
    }

    public static ResponseEntity<GetCustomerBoardCommentListResponseDto> success (List<CustomerBoardCommentEntity> customerBoardCommentEntities) throws Exception {

        GetCustomerBoardCommentListResponseDto responseBody = new GetCustomerBoardCommentListResponseDto(customerBoardCommentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
