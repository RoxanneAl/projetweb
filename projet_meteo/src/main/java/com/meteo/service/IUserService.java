package com.meteo.service;
import com.meteo.exceptions.UserNotFoundException;
import com.meteo.model.User;

import java.util.List;
public interface IUserService {

    User addUser(User user);

    User getById(int userId) throws UserNotFoundException;
    List<User> getAll();

}
