package com.angelalfaro.kinalapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.angelalfaro.kinalapp.entity.User;

@RequiredArgsConstructor
@Controller("/auth")
public class AuthWebController {

    @GetMapping("/")
    public String redirectLogin(){
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

}
