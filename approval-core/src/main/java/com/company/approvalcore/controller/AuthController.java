package com.company.approvalcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("auth")
public class AuthController {

    @GetMapping("token")
    public String authToken(@RequestParam("code") String code, Model model) {
        model.addAttribute("code", code);
        return "/auth/token";
    }

}
