package com.emp.config;

import com.emp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

public class SecurityConfig extends WebSecurityConfiguration {

    @Bean

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated().and()
                .httpBasic()
                .and()
                .build();
    }

    @Autowired
    public UserDetailsService userDetailsService() {
        //UserDetails user = User.new User("user1","password1", List.of(new SimpleGrantedAuthority("USER")));
        //User admin = new User("admin1","admin1",List.of(new SimpleGrantedAuthority("ADMIN")));
        //return new InMemoryUserDetailsManager(user,admin);
        //UserDetails user = User.builder()
               // .username("user")
               // .password(passwordEncoder().encode("password"))
               // .roles("user")
               // .build();
        //UserDetails admin = User.builder()
                //.username("user")
               // .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                //.roles("user", "admin")
                //.build();

        //return new InMemoryUserDetailsManager(user, admin);
        return new UserDetailsServiceImpl();
    }




    @Bean

    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("password1"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


    //@Bean

    //public PasswordEncoder passwordEncoder() {
        //PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
       // return encoder;
        //}


