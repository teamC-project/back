package com.back.back.dto.response.designerboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.DesignerBoardCommentEntity;

import lombok.Getter;
@Getter
public class GetDesignerBoardCommentResponseDto extends ResponseDto {
    
    private Integer designerBoardCommentNumber;
    private String designerBoardCommentContents;
    private String designerBoardCommentWriterId;
    private String designerBoardCommentWriteDatetime;

    private GetDesignerBoardCommentResponseDto (DesignerBoardCommentEntity designerBoardCommentEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.designerBoardCommentNumber = designerBoardCommentEntity.getDesignerBoardCommentNumber();
        this.designerBoardCommentContents = designerBoardCommentEntity.getDesignerBoardCommentContents();
        this.designerBoardCommentWriterId = designerBoardCommentEntity.getDesignerBoardCommentWriterId();
        this.designerBoardCommentWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(designerBoardCommentEntity.getDesignerBoardCommentWriteDatetime());
    }

    public static ResponseEntity<GetDesignerBoardCommentResponseDto> success (DesignerBoardCommentEntity designerBoardCommentEntity) throws Exception {
        
        GetDesignerBoardCommentResponseDto responseBody = new GetDesignerBoardCommentResponseDto(designerBoardCommentEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
