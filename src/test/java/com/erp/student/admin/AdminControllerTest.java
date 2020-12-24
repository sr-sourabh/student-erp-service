package com.erp.student.admin;

import com.erp.student.dto.AdminDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AdminControllerTest {

    @InjectMocks
    private AdminController underTest;

    @Mock
    private AdminService adminService;

    @Test
    public void test_getLoginStatus() {
        //initialize
        AdminDto request = new AdminDto();
        request.setUsername("test");
        request.setPassword("test");

        //mock
        Mockito.when(adminService.getLoginStatus(request)).thenReturn(true);

        //call
        boolean result = underTest.getLoginStatus(request);

        //assert
        Assertions.assertTrue(result);
    }
}