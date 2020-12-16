package com.erp.student.specialisation;

import com.erp.student.dto.SpecialisationDto;
import org.springframework.stereotype.Component;

@Component
public class SpecialisationTransformer {
    public SpecialisationDto toDto(Specialisation specialisation) {
        SpecialisationDto dto = new SpecialisationDto();
        if (specialisation != null) {
            dto.setCode(specialisation.getCode());
            dto.setDescription(specialisation.getDescription());
            dto.setName(specialisation.getName());
            dto.setYear(specialisation.getYear());
            dto.setCreditsRequired(specialisation.getCreditsRequired());
        }
        return dto;
    }
}
