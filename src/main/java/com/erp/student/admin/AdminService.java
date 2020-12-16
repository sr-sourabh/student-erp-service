package com.erp.student.admin;

import com.erp.student.dto.AdminDto;

public interface AdminService {
    boolean getLoginStatus(AdminDto request);
}
