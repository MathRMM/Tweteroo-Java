package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.PersonDTO;
import com.tweteroo.api.models.Person;
import com.tweteroo.api.repositories.PersonRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class SignupController {

    @Autowired
    private PersonRepository repository;
    
    @PostMapping
    public String create(@RequestBody @Valid PersonDTO req) {
        repository.save(new Person(req));
        return "Ok";
    }
}