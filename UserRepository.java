package com.emp.repo;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class UserRepository extends JpaRepository<User, String> {

    public Optional<org.springframework.security.core.userdetails.User> findByUsername(String username){
        return null;
    }
}
