package com.back.back.dto.response.designerboard;

import java.util.List;

import com.back.back.common.object.DesignerBoardListItem;
import com.back.back.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class GetDesignerBoardListResponseDto extends ResponseDto {
    
    private List<DesignerBoardListItem> designerboardList;

    
} 
