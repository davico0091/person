package com.example.user.repository;

import com.example.user.entity.PersonEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<PersonEntity, String> {
}
