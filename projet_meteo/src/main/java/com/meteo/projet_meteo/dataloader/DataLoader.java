package com.meteo.projet_meteo.dataloader;

import com.meteo.projet_meteo.model.WeatherApiResponse;
import com.meteo.projet_meteo.output.repository.WeatherRepository;
import com.meteo.projet_meteo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private final WeatherService weatherService;
    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    public DataLoader(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Liste des villes à ajouter
        String[] cities = {"Paris", "Londres", "Berlin", "Madrid", "Rome"};

        // Parcourir chaque ville et récupérer les données météorologiques
        for (String city : cities) {
            WeatherApiResponse weather = weatherService.getWeatherForToday(city);
            // Ici, enregistrez l'objet weather dans la base de données
            weatherService.saveWeather(weather);
        }
        System.out.println(weatherService.findAll());
    }
}
