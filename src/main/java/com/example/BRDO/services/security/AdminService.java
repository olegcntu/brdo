package com.example.BRDO.services.security;

import com.example.BRDO.models.security_model.Admin;
import com.example.BRDO.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean createAdmin(Admin admin) {
        String email = admin.getEmail();
        if (adminRepository.findAdminByEmail(email) != null) {
            return false;
        }

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        log.info("Saving Admin with email: {}", email);

        return true;
    }
}
