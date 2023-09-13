package com.example.ticket_api.entities.dto;

public class UserDto {
    private String email;
    private String password;
    private String password02;

    public UserDto(String email, String password, String password02) {
        this.email = email;
        this.password = password;
        this.password02 = password02;
    }

    public UserDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword02() {
        return password02;
    }

    public void setPassword02(String password02) {
        this.password02 = password02;
    }
}
