package com.back.back.dto.response.designerboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.io.Resource;

@Getter
@AllArgsConstructor
public class GetDesignerBoardImageResponseDto {
    private final Resource resource;
}
