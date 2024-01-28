package com.meteo.projet_meteo.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "weather")
@EntityListeners(AuditingEntityListener.class)
public class WeatherApiResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Integer id;
    private int queryCost;
    private double latitude;
    private double longitude;
    private String resolvedAddress;
    private String address;
    private String timezone;
    private double tzoffset;

    @OneToMany(mappedBy = "weatherApiResponse", cascade = CascadeType.ALL)
    private List<Day> days;

    public int getQueryCost() {
        return queryCost;
    }

    public void setQueryCost(int queryCost) {
        this.queryCost = queryCost;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getResolvedAddress() {
        return resolvedAddress;
    }

    public void setResolvedAddress(String resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getTzoffset() {
        return tzoffset;
    }

    public void setTzoffset(double tzoffset) {
        this.tzoffset = tzoffset;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    @Entity
    public static class Day {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "weather_id")
        private WeatherApiResponse weatherApiResponse;


        @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Hour> hours;

        private double temp;
        private double humidity;
        private double windspeed;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        @Entity
        public static class Hour {
            @ManyToOne
            @JoinColumn(name = "day_id")
            private Day day;

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            private double temp;
            private double humidity;
            private double windspeed;

            public double getTemp() {
                return temp;
            }

            public void setTemp(double temp) {
                this.temp = temp;
            }

            public double getHumidity() {
                return humidity;
            }

            public void setHumidity(double humidity) {
                this.humidity = humidity;
            }

            public double getWindspeed() {
                return windspeed;
            }

            public void setWindspeed(double windspeed) {
                this.windspeed = windspeed;
            }
        }
    }
}
