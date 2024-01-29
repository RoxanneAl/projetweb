package com.meteo.projet_meteo.output.repository;


import com.meteo.projet_meteo.model.WeatherApiResponse;
import com.meteo.projet_meteo.service.WeatherService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
 public interface WeatherRepository extends CrudRepository<WeatherApiResponse, Long> {


}
