package com.meteo.projet_meteo.output.webservices;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meteo.projet_meteo.model.Weather;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class WeatherWebService {
    private final String URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Lille,FR?key=E52WKLYZ4466XQEJWRQK553CA";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public WeatherWebService(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public Weather getWeather(){
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();

        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), Weather.class);
            } else {
                System.err.println("Erreur lors de la récupération des données. Code status : " + response.statusCode());
            }
        }
        catch(Exception e)
        {
            System.err.println("Erreur lors de l'envoi de la requête : " + e.getMessage());
        }
        return new Weather();
    }
}

