package com.meteo.projet_meteo;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class contactAPI {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static String RequesttoAPI(String url){
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responsebody = response.body();
                return responsebody;
            } else {
                System.err.println("Erreur lors de la récupération des données. Codes statut : " + response.statusCode());
            }
        }
        catch(Exception e)
        {
            System.err.println("Erreur lors de l'envoi de la requête : " + e.getMessage());
        }
        return url;
    }
}

