package com.stackroute.p2plp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.p2plp.repository.UserRepository;

@Service
public class UserLoginService {
    
    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String email, String password) {
        return userRepository.existsById(email) && userRepository.findById(email).get().getPassword().equals(password);
    }
}
