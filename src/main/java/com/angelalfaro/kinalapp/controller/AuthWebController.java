package com.angelalfaro.kinalapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.angelalfaro.kinalapp.entity.User;
import com.angelalfaro.kinalapp.service.user.UserServiceImpl;

@RequiredArgsConstructor
@Controller
public class AuthWebController {

    private final UserServiceImpl userService;

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

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userService.existsByUsername(user.getUsernameUser())) {
            // Sends an error message back to the view
            model.addAttribute("error", "Username is already taken");
            return "auth/register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid username or password");
        return "auth/login";
    }

}
