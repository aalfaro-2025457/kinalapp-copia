package com.angelalfaro.kinalapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class LoginWebController {

    @GetMapping("/")
    public String redirectLogin(){
        return "auth/login.html";
    }

}
