package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.Person;

public interface PersonRepository extends JpaRepository <Person, Long>{
    
}