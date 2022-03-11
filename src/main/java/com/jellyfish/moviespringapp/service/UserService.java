package com.jellyfish.moviespringapp.service;

import com.jellyfish.moviespringapp.dto.UserDto;
import com.jellyfish.moviespringapp.model.User;

public interface UserService {
    void addUser(User user);

    boolean userLogin(User user);

    User save(UserDto userDto);
}
