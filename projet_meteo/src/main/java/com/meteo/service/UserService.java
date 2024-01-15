package com.meteo.service;
import com.meteo.exceptions.UserNotFoundException;
import com.meteo.model.User;
import com.meteo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {
    IUserRepository userRepository;

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getById(int userId) throws UserNotFoundException {
        return userRepository
                .findById(userId)
                .orElseThrow(()-> new UserNotFoundException("invalid id"));
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

}
