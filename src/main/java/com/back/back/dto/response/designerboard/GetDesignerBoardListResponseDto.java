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
public class GetDesignerBoardListResponseDto extends ResponseDto {
    
    private List<DesignerBoardListItem> designerboardList;

    private GetDesignerBoardListResponseDto (List<DesignerBoardEntity> designerBoardEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.designerboardList = DesignerBoardListItem.getList(designerBoardEntities);
    }

    public static ResponseEntity<GetDesignerBoardListResponseDto> success (List<DesignerBoardEntity> designerBoardEntities) throws Exception {

        GetDesignerBoardListResponseDto responseBody = new GetDesignerBoardListResponseDto(designerBoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

} 
