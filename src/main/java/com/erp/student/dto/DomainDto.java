package com.erp.student.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DomainDto {
    private String program;
    private Long batch;
    private String qualification;
}
