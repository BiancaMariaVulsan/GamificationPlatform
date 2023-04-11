package com.example.server.dto;

public class LoginResponseDto {
    private int id;
    private String username;
    private int points;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public class LoginResultDto {
        private String token;
        private UserDto user;
    }
}