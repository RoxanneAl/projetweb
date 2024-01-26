package com.meteo.projet_meteo.input.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin_page")
    public String adminPage() {
        return "admin_page.html";
    }
}