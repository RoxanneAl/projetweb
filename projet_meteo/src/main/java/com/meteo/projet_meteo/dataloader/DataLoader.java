package com.meteo.projet_meteo.dataloader;
import com.meteo.projet_meteo.model.WeatherApiResponse;
import com.meteo.projet_meteo.output.repository.IUserRepository;
import com.meteo.projet_meteo.output.repository.WeatherRepository;
import com.meteo.projet_meteo.service.UserService;
import com.meteo.projet_meteo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.meteo.projet_meteo.model.Users;

import java.util.Optional;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private final WeatherService weatherService;
    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    UserService userService;
    @Autowired
    IUserRepository userRepository;

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
        //System.out.println(weatherService.findAll());

        // Vérifie si l'utilisateur admin existe déjà
        Optional<Users> adminOpt = userRepository.findByName("admin");

        if (adminOpt.isEmpty()) {
            // L'admin n'existe pas, donc on le crée
            Users adminUser = new Users("admin", "admin");
            userService.addUser(adminUser);
            System.out.println("Admin user created.");
        } else {
            // L'admin existe déjà, pas besoin de le créer
            System.out.println("Admin user already exists.");
        }
    }
}
