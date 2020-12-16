package com.erp.student.admin;

import com.erp.student.dto.AdminDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping(path = "/admin/login")
    public boolean getLoginStatus() {
        AdminDto request = new AdminDto();
        request.setPassword("test");
        request.setUsername("test");
        return adminService.getLoginStatus(request);
    }
}
