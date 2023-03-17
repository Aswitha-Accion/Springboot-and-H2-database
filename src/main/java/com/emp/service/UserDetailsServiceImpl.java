package com.emp.service;

import com.emp.repo.UserRepository;
//import jdk.internal.icu.impl.UBiDiProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;
import static org.hibernate.Hibernate.map;
import static org.springframework.security.config.http.MatcherType.ciRegex;
import static org.springframework.security.config.http.MatcherType.regex;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findByUsername(username);
       //org.springframework.security.core.userdetails.User.builder().username(user)
       return user.map(
               u -> {
                   try {
                       return User
                       .builder().username(u.getUsername())
                               .password(u.getPassword())
                                       .authorities(//Stream.of(
                                               //(GrantedAuthority)
                               // Stream.of(u.getUsername()
                                       Arrays.stream(u.getClass().wait(Long.parseLong("3000"))
                                                     .map(SimpleGrantedAuthority::new).collect(Collectors.toList())))
                               .build()
                       .orElseThrow(()->new UsernameNotFoundException("Invalid Username"));
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               });

    }
}
      //(Long.parseLong("3000")))