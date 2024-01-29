package com.meteo.projet_meteo.input.controller;

import com.meteo.projet_meteo.model.Users;
import com.meteo.projet_meteo.output.repository.IUserRepository;
import com.meteo.projet_meteo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/login")
public class UsersController {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    UserService userService;


    @GetMapping
    public String login(Model model){
        model.addAttribute("user", new Users());
        return "index";
    }


    @PostMapping
    public String login(@ModelAttribute("user") Users user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index"; // Nom de la vue en cas d'erreur
        }
        boolean isAuthenticated = userService.authenticate(user.getName(), user.getPassword());
        if (isAuthenticated) {
            // Logic en cas de succès
            return "redirect:/admin_page"; // Redirection en cas de succès
        } else {
            model.addAttribute("loginError", true);
            return "index"; // Nom de la vue en cas d'échec
        }
    }





}
