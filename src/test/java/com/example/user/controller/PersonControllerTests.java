package com.example.user.controller;

import com.example.user.model.Person;
import com.example.user.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers =PersonController.class )
public class PersonControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private PersonService personService;

    @Test
    @DisplayName("given person obect when create person then return person")
    public void givenPersonObject_whenCreatePerson_thenReturnPerson(){

        Person person = Person.builder()
                .name("david")
                .lastname("perez")
                .email("email")
                .address("address")
                .build();

        given(personService.savePerson(any(Person.class)))
                .willReturn(Mono.just(person));

        WebTestClient.ResponseSpec response = webTestClient.post().uri("/api/person/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(person),Person.class)
                .exchange();

        response.expectStatus().isCreated()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.name").isEqualTo(person.getName())
                .jsonPath("$.lastname").isEqualTo(person.getLastname())
                .jsonPath("$.email").isEqualTo(person.getEmail())
                .jsonPath("$.address").isEqualTo(person.getAddress());

    }

    @Test
    @DisplayName("given PersonId whenGetPerson thenReturnPersonObject")
    public void givenPersonId_whenGetPerson_thenReturnPersonObject(){

        String personId = "643341e161c40448b1c164b0";

        Person person = Person.builder()
                .idPerson("643341e161c40448b1c164b0")
                .name("David")
                .lastname("Perez")
                .email("email@correo.com")
                .address("direccion mza")
                .build();

        given(personService.getPerson(personId))
                .willReturn(Mono.just(person));

        WebTestClient.ResponseSpec response = webTestClient.get()
                .uri("/api/person/{id}", Collections.singletonMap("id",personId))
                .exchange();

        response.expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.idPerson").isEqualTo(person.getIdPerson())
                .jsonPath("$.name").isEqualTo(person.getName())
                .jsonPath("$.lastname").isEqualTo(person.getLastname())
                .jsonPath("$.email").isEqualTo(person.getEmail())
                .jsonPath("$.address").isEqualTo(person.getAddress());
    }


    @Test
    @DisplayName("given list of persons when get all persons then return all persons")
    public void givenListOfPersonWhenGetPersonsThenReturnPersons(){

        List<Person> listOfPersons = new ArrayList<>();
        listOfPersons
                .add(
                        Person.builder()
                                .idPerson("643341e161c40448b1c164b1")
                                .name("name1")
                                .lastname("lastname1")
                                .email("email1")
                                .address("address1")
                                .build()
                );
        listOfPersons
                .add(
                        Person.builder()
                                .idPerson("643341e161c40448b1c164b2")
                                .name("name2")
                                .lastname("lastname2")
                                .email("email2")
                                .address("address2")
                                .build()
                );
        Flux<Person> personFlux = Flux.fromIterable(listOfPersons);

        given(personService.getAllPersons())
                .willReturn(personFlux);

        WebTestClient.ResponseSpec response = webTestClient
                .get()
                .uri("/api/person/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        response.expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Person.class)
                .consumeWith(System.out::println);



    }
    @Test
    @DisplayName("given person obect when update person then return person")
    public void givenPersonObject_whenUpdatePerson_thenReturnPerson(){

        Person person = Person.builder()
                .name("david")
                .lastname("perez")
                .email("email")
                .address("address")
                .build();

        given(personService.updatePerson(any(Person.class)))
                .willReturn(Mono.just(person));

        WebTestClient.ResponseSpec response = webTestClient.put().uri("/api/person/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(person),Person.class)
                .exchange();

        response.expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.name").isEqualTo(person.getName())
                .jsonPath("$.lastname").isEqualTo(person.getLastname())
                .jsonPath("$.email").isEqualTo(person.getEmail())
                .jsonPath("$.address").isEqualTo(person.getAddress());

    }

}