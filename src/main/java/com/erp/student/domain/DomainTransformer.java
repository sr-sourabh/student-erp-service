package com.erp.student.domain;

import com.erp.student.dto.DomainDto;
import org.springframework.stereotype.Component;

@Component
public class DomainTransformer {
    public DomainDto toDto(Domain domain) {
        DomainDto domainDto = new DomainDto();

        if (domain == null) return domainDto;

        domainDto.setBatch(domain.getBatch());
        domainDto.setProgram(domain.getProgram());
        domainDto.setQualification(domain.getQualification());
        return domainDto;
    }
}
