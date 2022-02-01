package com.urlShortener.DTO;

public class JWTRequest {

    private String email;
    private String password;

    public JWTRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public JWTRequest() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}