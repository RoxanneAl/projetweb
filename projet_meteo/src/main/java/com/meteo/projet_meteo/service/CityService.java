package com.meteo.projet_meteo.service;

import com.meteo.projet_meteo.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    public List<City> getTowns(){
        return List.of(new City("test"), new City("test1"));
    }
}
