package com.emp.service;

import com.emp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findByUsername(username);
       //org.springframework.security.core.userdetails.User.builder().username(user)
       return user.map(u -> User
               .builder().username(u.getUsername()).password(u.getPassword())
               .authorities(Stream.of(u.getRoles().split(","))
                       .map(r-> new SimpleGrantedAuthority(r))))

    }
}
