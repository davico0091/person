package com.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "person")
@Data
@AllArgsConstructor
public class PersonEntity {
    @Id
    private String idPerson;
    private String name;
    private String lastname;
    private String email;
    private String address;
}
