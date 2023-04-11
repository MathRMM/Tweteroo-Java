package com.tweteroo.api.models;

import com.tweteroo.api.dto.PersonDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Person {
    
    public Person(PersonDTO req){
        this.username = req.username();
        this.avatar = req.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25, nullable = false)
    private String username;

    @Column(length = 255, nullable = false)
    private String avatar;
}
