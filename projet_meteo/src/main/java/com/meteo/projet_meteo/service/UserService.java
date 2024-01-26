package com.meteo.projet_meteo.service;
import com.meteo.projet_meteo.exceptions.UserNotFoundException;
import com.meteo.projet_meteo.model.Users;
import com.meteo.projet_meteo.output.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService  {

    @Autowired
    IUserRepository userRepository;


    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users addUser(Users users){
        return userRepository.save(users);
    }
/*
    public Users getById(int userId) throws UserNotFoundException {
        return userRepository
                .findById(userId)
                .orElseThrow(()-> new UserNotFoundException("invalid id"));
    }

    public Users getByName(String name) throws UserNotFoundException {
        return userRepository
                .findByName(name)
                .orElseThrow(()-> new UserNotFoundException("invalid name"));
    }
    */

    @Autowired
    public List<Users> getAll(){
        return (List<Users>) userRepository.findAll();
    }

    public boolean authenticate(String username, String password) {
        Optional<Users> user = userRepository.findByName(username);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return true; // Utilisateur authentifié avec succès
        } else {
            return false; // Échec de l'authentification
        }
    }
}
