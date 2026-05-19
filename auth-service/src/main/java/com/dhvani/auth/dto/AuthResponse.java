package com.dhvani.auth.dto;

public class AuthResponse {

    private String message;
    private String token;

    public AuthResponse(String message , String token) {
        this.message = message;
        this.message = token;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

}