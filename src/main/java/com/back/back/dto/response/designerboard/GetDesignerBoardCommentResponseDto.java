package com.back.back.dto.response.designerboard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.DesignerBoardCommentEntity;
import lombok.Getter;
@Getter
public class GetDesignerBoardCommentResponseDto extends ResponseDto {
    
    private Integer designerBoardCommentNumber;
    private String designerBoardCommentWriterId;
    private String designerBoardCommentWriteDatetime;
    private String designerBoardCommentContents;
    private GetDesignerBoardCommentResponseDto (DesignerBoardCommentEntity designerBoardCommentEntity) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        String designerCommentWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(designerBoardCommentEntity.getDesignerBoardCommentWriteDatetime());

        this.designerBoardCommentNumber = designerBoardCommentEntity.getDesignerBoardCommentNumber();
        this.designerBoardCommentWriterId = designerBoardCommentEntity.getDesignerBoardCommentWriterId();
        this.designerBoardCommentWriteDatetime = designerCommentWriteDatetime;
        this.designerBoardCommentContents = designerBoardCommentEntity.getDesignerBoardCommentContents();
    }

    public static ResponseEntity<GetDesignerBoardCommentResponseDto> success (DesignerBoardCommentEntity designerBoardCommentEntity) throws Exception {
        GetDesignerBoardCommentResponseDto responseBody = new GetDesignerBoardCommentResponseDto(designerBoardCommentEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
