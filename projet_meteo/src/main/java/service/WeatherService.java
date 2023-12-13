package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.WeatherData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import repository.WeatherDataRepository;

public class WeatherService {

    private final String apiUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Lille,FR/2022-12-12T13:0:0?key=E52WKLYZ4466XQEJWRQK553CA&include=days&elements=humidity,windspeed,temp";
    private final RestTemplate restTemplate;
    private final WeatherDataRepository weatherDataRepository;

    public WeatherService(RestTemplate restTemplate, WeatherDataRepository weatherDataRepository) {
        this.restTemplate = restTemplate;
        this.weatherDataRepository = weatherDataRepository;
    }

    public void fetchDataAndSave() {
        // Faire la requête à l'API
        String jsonResult = restTemplate.getForObject(apiUrl, String.class);

        try {
            // Désérialiser la réponse JSON en objets Java
            WeatherData weatherData = new ObjectMapper().readValue(jsonResult, WeatherData.class);

            // Enregistrer les données dans la base de données
            weatherDataRepository.save(weatherData);
        } catch (Exception e) {
            // Gérer les erreurs (par exemple, journaliser, renvoyer une réponse d'erreur, etc.)
            e.printStackTrace();
        }
    }

}
