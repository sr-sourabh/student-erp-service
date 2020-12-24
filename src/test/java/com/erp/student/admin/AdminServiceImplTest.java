package com.erp.student.admin;

import com.erp.student.dto.AdminDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {

    @InjectMocks
    private AdminServiceImpl underTest;

    @Mock
    private AdminRepository adminRepository;

    @Test
    public void test_getLoginStatus() {
        AdminDto request = new AdminDto();
        request.setUsername("test");
        request.setPassword("test");

        Admin admin = new Admin();

        Mockito.when(adminRepository
                .findByUsernameAndPassword(request.getUsername(), DigestUtils.sha384Hex(request.getPassword())))
                .thenReturn(admin);

        boolean result = underTest.getLoginStatus(request);

        Assertions.assertTrue(result);
    }

}