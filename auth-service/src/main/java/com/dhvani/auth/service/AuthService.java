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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    public AuthResponse register(RegisterRequest request) {

        logger.info("Register request received for email: {}", request.getEmail());

        if (userRepository.existsByEmail(request.getEmail())) {
            logger.warn("Registration failed: email already exists -> {}", request.getEmail());
            throw new DuplicateEmailException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);

        logger.info("User registered successfully with email: {}", user.getEmail());

        return new AuthResponse("User registered successfully", null);
    }

//    public AuthResponse login(LoginRequest request) {
//
//        User user = userRepository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new UserNotFoundException("User not found"));
//
//        boolean passwordMatches = passwordEncoder.matches(
//                request.getPassword(),
//                user.getPassword()
//        );
//
//        if (!passwordMatches) {
//            throw new RuntimeException("Invalid credentials");
//        }
//
//        return new AuthResponse("Login successful");
//    }

    public AuthResponse login(LoginRequest request) {

        logger.info("Login attempt for email: {}", request.getEmail());

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> {
                    logger.warn("Login failed: user not found -> {}", request.getEmail());
                    return new UserNotFoundException("User not found");
                });

        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!passwordMatches) {
            logger.warn("Login failed: invalid password for email -> {}", request.getEmail());
            throw new RuntimeException("Invalid credentials");
        }

        logger.info("Login successful for email: {}", request.getEmail());

        return new AuthResponse("Login successful", null);
    }

}