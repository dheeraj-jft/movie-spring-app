package com.jellyfish.moviespringapp.service.impl;

import com.jellyfish.moviespringapp.dto.UserDto;
import com.jellyfish.moviespringapp.model.User;
import com.jellyfish.moviespringapp.repository.UserRepository;
import com.jellyfish.moviespringapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean userLogin(User user) {
        User user1 = userRepository.findByUsername(user.getUsername());
        if (user1 != null) {
            return user1.getPassword().equals(user.getPassword());
        }
        return false;
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

}
