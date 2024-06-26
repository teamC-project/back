package com.back.back.dto.response.designerboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.entity.DesignerBoardEntity;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.util.ChangeDateFormatUtil;

import lombok.Getter;
@Getter
public class GetDesignerBoardResponseDto extends ResponseDto {
    
    private Integer designerBoardNumber;
    private String designerBoardTitle;
    private String designerBoardContents;
    private String designerBoardWriterId;
    private String designerBoardWriteDatetime;
    private Integer designerBoardViewCount;

    private GetDesignerBoardResponseDto(DesignerBoardEntity designerBoardEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.designerBoardNumber = designerBoardEntity.getDesignerBoardNumber();
        this.designerBoardTitle = designerBoardEntity.getDesignerBoardTitle();
        this.designerBoardContents = designerBoardEntity.getDesignerBoardContents();
        this.designerBoardWriterId = designerBoardEntity.getDesignerBoardWriterId();
        this.designerBoardWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(designerBoardEntity.getDesignerBoardWriteDatetime());
        this.designerBoardViewCount = designerBoardEntity.getDesignerBoardViewCount();
    }

    public static ResponseEntity<GetDesignerBoardResponseDto> success(DesignerBoardEntity designerBoardEntity) throws Exception {

        GetDesignerBoardResponseDto responseBody = new GetDesignerBoardResponseDto(designerBoardEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
