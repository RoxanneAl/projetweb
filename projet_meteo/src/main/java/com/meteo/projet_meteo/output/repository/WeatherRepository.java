package com.meteo.projet_meteo.output.repository;


import com.meteo.projet_meteo.model.WeatherApiResponse;
import com.meteo.projet_meteo.service.WeatherService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class WeatherRepository implements JpaRepository<WeatherService, Long> {

    @Override
    public void flush() {
        
    }

    @Override
    public <S extends WeatherService> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends WeatherService> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<WeatherService> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public WeatherService getOne(Long aLong) {
        return null;
    }

    @Override
    public WeatherService getById(Long aLong) {
        return null;
    }

    @Override
    public WeatherService getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends WeatherService> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends WeatherService> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends WeatherService> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends WeatherService> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends WeatherService> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends WeatherService> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends WeatherService, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    public static <S extends WeatherService> S save(WeatherApiResponse entity) {
        return null;
    }

    @Override
    public <S extends WeatherService> S save(S entity) {
        return null;
    }

    @Override
    public <S extends WeatherService> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<WeatherService> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<WeatherService> findAll() {
        return null;
    }

    @Override
    public List<WeatherService> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(WeatherService entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends WeatherService> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<WeatherService> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<WeatherService> findAll(Pageable pageable) {
        return null;
    }
}
