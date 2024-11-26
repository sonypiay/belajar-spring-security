package com.sonypiay.security.security_demo.repository;

import com.sonypiay.security.security_demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
