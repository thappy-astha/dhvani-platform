package com.dhvani.auth.service;

import com.dhvani.auth.dto.RegisterRequest;
import com.dhvani.auth.entity.User;
import com.dhvani.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterRequest request) {

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        userRepository.save(user);

        return "User registered successfully";
    }
}