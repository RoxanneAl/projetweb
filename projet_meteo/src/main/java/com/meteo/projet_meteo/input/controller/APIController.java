package com.meteo.projet_meteo.input.controller;

import com.meteo.projet_meteo.model.WeatherApiResponse;
import com.meteo.projet_meteo.output.repository.WeatherRepository;
import com.meteo.projet_meteo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/api_donnees")
public class APIController {

    @Autowired
    WeatherService weatherService;
    @Autowired
    WeatherRepository weatherRepository;
    @GetMapping
    public List<WeatherApiResponse> getAllWeather() {
        return weatherService.findAll();
    }
}
