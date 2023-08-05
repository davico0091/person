package com.example.user.service;

import com.example.user.model.DocumentXls;
import com.example.user.model.Person;
import com.example.user.model.Term;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
    Mono<Person> savePerson(Person person);

    Flux<Person> getAllPersons();

    Mono<Person> getPerson(String personId);

    Mono<Person> updatePerson(Person person);

    Mono<String> readXls(DocumentXls document);
}
