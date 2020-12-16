package com.erp.student.admin;

import com.erp.student.dto.AdminDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;

    @Override
    public boolean getLoginStatus(AdminDto request) {
        Admin admin = adminRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        return Objects.nonNull(admin);
    }
}
