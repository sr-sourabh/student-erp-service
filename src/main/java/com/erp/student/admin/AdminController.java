package com.erp.student.admin;

import com.erp.student.dto.AdminDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    @PutMapping(path = "/admin/login")
    public boolean getLoginStatus(@RequestBody AdminDto request) {
        return adminService.getLoginStatus(request);
    }
}
