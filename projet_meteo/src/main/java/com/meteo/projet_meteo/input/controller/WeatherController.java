package com.meteo.projet_meteo.input.controller;

import com.meteo.projet_meteo.model.Weather;
import com.meteo.projet_meteo.output.webservices.WeatherWebService;
import com.meteo.projet_meteo.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    private CityService villesService;
    private WeatherWebService weatherWebService;
    public WeatherController(CityService villesService, WeatherWebService weatherWebService) {
        this.villesService = villesService;
        this.weatherWebService = weatherWebService;
    }

    @GetMapping("/")
    public String index(Model model){
        Weather weather = weatherWebService.getWeather();
        model.addAttribute("towns", villesService.getTowns());
        return "index";
    }
}
