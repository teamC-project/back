package com.back.back.dto.response.designerboard;

import org.springframework.core.io.Resource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetDesignerBoardImageResponseDto {
    private final Resource resource;
}
