package com.back.back.dto.response.designerboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.DesignerBoardCommentEntity;
import com.back.back.common.object.DesignerBoardCommentListItem;

import lombok.Getter;

@Getter
public class GetDesignerBoardCommentListResponseDto extends ResponseDto {
    
    private List<DesignerBoardCommentListItem> designerBoardCommentList;

    private GetDesignerBoardCommentListResponseDto (List<DesignerBoardCommentEntity> designerBoardCommentEntities) throws Exception {
        
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.designerBoardCommentList = DesignerBoardCommentListItem.getList(designerBoardCommentEntities);
    }

    public static ResponseEntity<GetDesignerBoardCommentListResponseDto> success (List<DesignerBoardCommentEntity> designerBoardCommentEntities) throws Exception {

        GetDesignerBoardCommentListResponseDto responseBody = new GetDesignerBoardCommentListResponseDto(designerBoardCommentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
