package com.example.service;

import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Test
    void getUser() {
        UserDetails test = customUserDetailsService.loadUserByUsername("admin");
        test.getAuthorities().forEach(auth -> System.out.println(auth.getAuthority()));
    }

}