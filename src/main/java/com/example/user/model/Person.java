package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Person {

    private String idPerson;
    private String name;
    private String lastname;
    private String email;
    private String address;
}
