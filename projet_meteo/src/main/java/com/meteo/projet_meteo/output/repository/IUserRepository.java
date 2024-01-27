package com.meteo.projet_meteo.output.repository;

import com.meteo.projet_meteo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface IUserRepository extends CrudRepository<Users, Integer> {
    List<Users> findAll();
    Optional<Users> findByName(String name);

    List<Users> findById(int uid);
}

