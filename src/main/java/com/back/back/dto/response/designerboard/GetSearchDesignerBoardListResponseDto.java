package com.back.back.dto.response.designerboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.entity.DesignerBoardEntity;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.object.DesignerBoardListItem;

import lombok.Getter;

@Getter
public class GetSearchDesignerBoardListResponseDto extends ResponseDto {
    
    private List<DesignerBoardListItem> designerBoardList;

    private GetSearchDesignerBoardListResponseDto (List<DesignerBoardEntity> designerBoardEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.designerBoardList = DesignerBoardListItem.getList(designerBoardEntities);
    }

    public static ResponseEntity<GetSearchDesignerBoardListResponseDto> success (List<DesignerBoardEntity> designerBoardEntities) throws Exception {

        GetSearchDesignerBoardListResponseDto responseBody = new GetSearchDesignerBoardListResponseDto(designerBoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
