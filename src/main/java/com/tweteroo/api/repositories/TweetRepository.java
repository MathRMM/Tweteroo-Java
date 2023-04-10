package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.tweteroo.api.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Id> {
    
}
