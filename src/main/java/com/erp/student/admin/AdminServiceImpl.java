package com.erp.student.admin;

import com.erp.student.dto.AdminDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;

    @Override
    public boolean getLoginStatus(AdminDto request) {
        String password = DigestUtils.sha384Hex(request.getPassword());
        Admin admin = adminRepository.findByUsernameAndPassword(request.getUsername(), password);
        return Objects.nonNull(admin);

    }
}
