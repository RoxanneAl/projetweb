package com.meteo.projet_meteo.service;

import com.meteo.projet_meteo.model.WeatherApiResponse;
import com.meteo.projet_meteo.output.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired // Utilisez @Autowired pour injecter RestTemplate si c'est un bean
    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public WeatherApiResponse getWeatherForToday(String location) {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ISO_LOCAL_DATE);

        String urlTemplate = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/{location}/{date}";

        String url = UriComponentsBuilder.fromHttpUrl(urlTemplate)
                .queryParam("key", apiKey)
                .queryParam("include", "hours")
                .buildAndExpand(location, formattedDate)
                .toUriString();

        return restTemplate.getForObject(url, WeatherApiResponse.class);
    }
}
