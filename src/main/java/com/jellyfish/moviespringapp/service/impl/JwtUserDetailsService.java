package com.jellyfish.moviespringapp.service.impl;

import com.jellyfish.moviespringapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.jellyfish.moviespringapp.model.User user = userRepository.findByUsername(username);
        if(user!=null) {
            return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
        }
        else return null;
    }


}
