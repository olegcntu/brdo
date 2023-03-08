package com.example.BRDO.repositories;

import com.example.BRDO.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
