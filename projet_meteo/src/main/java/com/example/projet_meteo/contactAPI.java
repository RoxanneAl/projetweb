package com.example.projet_meteo;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class contactAPI {
    String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Lille,FR/2022-12-12?key=E52WKLYZ4466XQEJWRQK553CA&include=days&elements=humidity,windspeed,temp";
    HttpClient httpClient = HttpClient.newHttpClient();

    public void RequesttoAPI(){
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responsebody = response.body();
                System.out.println(responsebody);
            } else {
                System.err.println("Erreur lors de la récupération des données. Codes statut : " + response.statusCode());
            }
        }
        catch(Exception e)
        {
            System.err.println("Erreur lors de l'envoi de la requête : " + e.getMessage());
        }
    }
}

