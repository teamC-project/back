package com.back.back.dto.response.customerboard;

import org.springframework.core.io.Resource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetCustomerBoardImageResponseDto {
    private final Resource resource;
}
