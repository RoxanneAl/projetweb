package com.meteo.projet_meteo.input.controller;

import ch.qos.logback.core.model.Model;
import com.meteo.projet_meteo.model.WeatherApiResponse;
import com.meteo.projet_meteo.output.repository.WeatherRepository;
import com.meteo.projet_meteo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/api_donnes")
public class WeatherController {

    @Autowired
    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    /*
    @GetMapping("/home")
    public String getWeather(@RequestParam String city, Model model) {
        WeatherApiResponse weather = weatherService.getWeatherForToday(city);
        //model.addAttribute("weather", weather);
        return "home";
    }

     */


    @GetMapping("/home")
    public String getWeather(Model model) {

        return "home";
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