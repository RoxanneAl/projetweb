package com.meteo.projet_meteo.model;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "weatherdata")
public class WeatherData {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double lat;
    private double lng;
    private String title;
    private List<Double> temperature;
    private List<Double> windSpeed;
    private List<Double> humidity;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    // Getters et Setters




    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Double> temperature) {
        this.temperature = temperature;
    }

    public List<Double> getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(List<Double> windSpeed) {
        this.windSpeed = windSpeed;
    }

    public List<Double> getHumidity() {
        return humidity;
    }

    public void setHumidity(List<Double> humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", title='" + title + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", humidity=" + humidity +
                '}';
    }

    public WeatherData() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
