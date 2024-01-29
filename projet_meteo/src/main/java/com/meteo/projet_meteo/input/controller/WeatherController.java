package com.meteo.projet_meteo.input.controller;


import com.meteo.projet_meteo.model.Users;
import com.meteo.projet_meteo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
//@RequestMapping("/api_donnes")
public class WeatherController {

    @Autowired
    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }



    @GetMapping("/home")
    public String getWeather(Model model) {

        return "home";
    }

    @GetMapping
    public String getAccueil(Model model){
        model.addAttribute("user",new Users());
        return "home";
    }


    @GetMapping("/donnees")
    public String showWeatherData(Model model) {
        model.addAttribute("data", weatherService.findAll());
        return "weather_data"; // Nom du template Thymeleaf
    }
    @GetMapping("/static/home_style.css")
    public String getcss(Model model){
        return "../static/home_style.css";
    }

    @GetMapping("static/home_dy.js")
    public String getjs(Model model){
        return "../static/home_dy.js";
    }

}