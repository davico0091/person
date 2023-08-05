package com.example.user.controller;

import com.example.user.configuration.ConfigProperties;
import com.example.user.model.DocumentXls;
import com.example.user.model.Person;
import com.example.user.model.Term;
import com.example.user.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController()
@RequestMapping("api/person")
@Slf4j
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<Person> savePerson(@RequestBody Person person){
        log.info("hola mundo");
        return personService.savePerson(person);
    }
    @GetMapping("/")
    public Flux<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Person>> getPerson(@PathVariable("id") String personId){
        return personService.getPerson(personId)
                .map(s -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(s))
                .switchIfEmpty((Mono<? extends ResponseEntity<Person>>) ResponseEntity.noContent());
    }

    @PutMapping("/")
    public Mono<Person> updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    @PostMapping("/read")
    public Mono<String> readXls(@RequestBody DocumentXls document){
        return personService.readXls(document);
    }


}
