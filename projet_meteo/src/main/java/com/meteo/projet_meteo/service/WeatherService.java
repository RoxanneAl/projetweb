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
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;


    public WeatherApiResponse saveWeather(WeatherApiResponse weather) {
        if (isDuplicateWeatherEntry(weather.getResolvedAddress(), weather.getAddress())) {
            throw new IllegalStateException("Un enregistrement météo pour cette date et ce lieu existe déjà.");
        }return weatherRepository.save(weather);
    }


    @Autowired // Utilisez @Autowired pour injecter RestTemplate si c'est un bean
    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public boolean isDuplicateWeatherEntry(String date, String location) {
        return weatherRepository.findByDateAndLocation(date, location).isPresent();
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

    public List<WeatherApiResponse> findAll() {
        return (List<WeatherApiResponse>) weatherRepository.findAll();
    }

}
