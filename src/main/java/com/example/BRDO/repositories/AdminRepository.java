package com.example.BRDO.repositories;

import com.example.BRDO.models.security_model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByEmail(String email);
}
