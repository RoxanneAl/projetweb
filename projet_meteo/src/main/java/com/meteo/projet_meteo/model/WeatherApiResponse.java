package com.meteo.projet_meteo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;

@Entity
public class WeatherApiResponse {
    private int queryCost;
    private double latitude;
    private double longitude;
    private String resolvedAddress;
    private String address;
    private String timezone;
    private double tzoffset;

    @JsonProperty("days")
    private Day[] days;

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

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

    public static class Day {
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

        public static class Hour {
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
