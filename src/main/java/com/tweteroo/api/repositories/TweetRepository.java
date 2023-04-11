package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.tweteroo.api.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Id> {

    Page<Tweet> findAllByOrderByCreatedAtDesc(Pageable pageable);

    List<Tweet> findByUsername(String username);
    
}
