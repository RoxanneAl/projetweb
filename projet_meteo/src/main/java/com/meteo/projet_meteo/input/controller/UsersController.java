package com.meteo.projet_meteo.input.controller;

import ch.qos.logback.core.model.Model;
import com.meteo.projet_meteo.model.Users;
import com.meteo.projet_meteo.output.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UsersController {

    @Autowired
    IUserRepository userRepository;

    @GetMapping
    public String home(Model model){
        return "index";
    }



}
