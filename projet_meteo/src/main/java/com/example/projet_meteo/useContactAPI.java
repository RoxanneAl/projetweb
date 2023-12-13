package com.example.projet_meteo;

public class useContactAPI {
    public static void main(String[] args){
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Lille,FR/2022-12-12T13:0:0?key=E52WKLYZ4466XQEJWRQK553CA&include=days&elements=humidity,windspeed,temp";
        String data;
        new contactAPI();
        data = contactAPI.RequesttoAPI(url);
        System.out.println(data);
    }
}
