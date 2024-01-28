package com.meteo.projet_meteo.input.controller;

import ch.qos.logback.core.model.Model;
import com.meteo.projet_meteo.model.WeatherApiResponse;
import com.meteo.projet_meteo.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/home")
    public String getWeather(@RequestParam String city, Model model) {
        WeatherApiResponse weather = weatherService.getWeatherForToday(city);
        //model.addAttribute("weather", weather);
        return "home";
    }
}