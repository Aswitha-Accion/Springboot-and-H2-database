package com.emp.service;

import com.emp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User addUser(User user){
        user.getPassword(PasswordEncoder.encode(user.getPassword()));

        return new userRepository.save(user);
    }
}
