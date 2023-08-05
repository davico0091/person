package com.example.user.mapper;

import com.example.user.entity.PersonEntity;
import com.example.user.model.Person;

public class PersonMapper {
    public static Person mapToPerson(PersonEntity personEntity){
      return new Person(
              personEntity.getIdPerson(),
              personEntity.getName(),
              personEntity.getLastname(),
              personEntity.getEmail(),
              personEntity.getAddress()
      );
    }

    public static PersonEntity mapToPersonEntity(Person person){
        return new PersonEntity(
                person.getIdPerson(),
                person.getName(),
                person.getLastname(),
                person.getEmail(),
                person.getAddress()
        );
    }
}
