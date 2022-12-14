package com.springboot.domain.dto;

public class UserRequestDto {
    private String name;
    private String id;
    private String password;
    public UserRequestDto(String id, String name, String password){
        this.name=name;
        this.id=id;
        this.password=password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
