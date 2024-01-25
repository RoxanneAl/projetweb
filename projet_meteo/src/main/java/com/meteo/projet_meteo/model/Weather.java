package com.meteo.projet_meteo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Weather {
    private Double latitude;

    private Double longitude;
    private String resolvedAddress;
    @JsonIgnoreProperties("currentConditions")
    private CurrentConditions currentConditions;

    public Weather(Double latitude, Double longitude, String resolvedAddress, CurrentConditions currentConditions) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.resolvedAddress = resolvedAddress;
        this.currentConditions = currentConditions;
    }

    public Weather() {
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getResolvedAddress() {
        return resolvedAddress;
    }

    public void setResolvedAddress(String resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }

    public CurrentConditions getCurrentCondition() {
        return currentConditions;
    }

    public void setCurrentCondition(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }
}

class CurrentConditions {
    private Double temp;
    private Double humidity;

    public CurrentConditions(Double temp, Double humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public CurrentConditions() {
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
}
