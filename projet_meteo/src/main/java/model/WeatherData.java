package model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;

    private Double longitude;

    @JsonProperty("resolvedAddress")
    private String resolvedAddress;

    private String address;

    private String timezone;

    private Double tzoffset;

    @JsonProperty("days")
    private WeatherDay[] days;
    public class WeatherDay{
        private Double temp;

        private Double humidity;


        @JsonProperty("windspeed")
        private Double windSpeed;
    }


}
