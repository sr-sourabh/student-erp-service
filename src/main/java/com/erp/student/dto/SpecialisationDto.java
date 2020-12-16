package com.erp.student.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpecialisationDto {
    private Long code;
    private String year;
    private String description;
    private String name;
    private Long creditsRequired;
}
