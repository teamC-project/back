package com.back.back.dto.response.designerboard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.DesignerBoardEntity;
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
        String designerWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDD(designerBoardEntity.getDesignerBoardWriteDatetime());

        this.designerBoardNumber = designerBoardEntity.getDesignerBoardNumber();
        this.designerBoardTitle = designerBoardEntity.getDesignerBoardTitle();
        this.designerBoardWriterId = designerBoardEntity.getDesignerBoardWriterId();
        this.designerBoardWriteDatetime = designerWriteDatetime;
        this.designerBoardViewCount = designerBoardEntity.getDesignerBoardViewCount();
        this.designerBoardContents = designerBoardEntity.getDesignerBoardContents();
    }

    public static ResponseEntity<GetDesignerBoardResponseDto> success(DesignerBoardEntity designerBoardEntity) throws Exception {
        GetDesignerBoardResponseDto responseBody = new GetDesignerBoardResponseDto(designerBoardEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }


}
