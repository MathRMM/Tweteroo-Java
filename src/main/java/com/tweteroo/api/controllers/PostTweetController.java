package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.TweetRepository;



@RestController
@RequestMapping("/api/tweet")
public class PostTweetController {
    @Autowired
    private TweetRepository repository;

    @PostMapping
    public void create(@RequestBody TweetDTO req){
       repository.save(new Tweet(req));
    }

    @GetMapping
    public List<Tweet> read(){
        List<Tweet> tweet = repository.findAll(); 
        return tweet;
    }
}
