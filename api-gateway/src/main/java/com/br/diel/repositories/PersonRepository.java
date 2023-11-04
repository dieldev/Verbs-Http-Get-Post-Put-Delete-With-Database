package com.br.diel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.diel.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
