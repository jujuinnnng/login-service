package com.example.controller;

import com.example.entity.User;
import com.example.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@RequiredArgsConstructor
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;

    @GetMapping("/user/{username}")
    public User getUser(Model model, @PathVariable String username) {

        return null;
    }

}
