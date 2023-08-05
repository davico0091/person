package com.example.user.model;

import lombok.Data;

@Data
public class User {
    private int idUser;
    private String username;
    private String password;
    private Person person;

}
