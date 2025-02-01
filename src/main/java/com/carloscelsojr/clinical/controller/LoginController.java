package com.carloscelsojr.clinical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String carregaPaginaListagem(){
        return "auth/login";
    }

}