package com.dhvani.auth.service;

import com.dhvani.auth.dto.AuthResponse;
import com.dhvani.auth.dto.RegisterRequest;
import com.dhvani.auth.entity.User;
import com.dhvani.auth.exception.DuplicateEmailException;
import com.dhvani.auth.exception.UserNotFoundException;
import com.dhvani.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.dhvani.auth.dto.LoginRequest;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);

        return new AuthResponse("User registered successfully");
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!passwordMatches) {
            throw new RuntimeException("Invalid credentials");
        }

        return new AuthResponse("Login successful");
    }

}