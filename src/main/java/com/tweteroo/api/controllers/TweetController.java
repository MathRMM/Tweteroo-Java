package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.TweetRepository;



@RestController
@RequestMapping("/api/tweet")
public class TweetController {
    @Autowired
    private TweetRepository repository;

    @PostMapping
    public void create(@RequestBody TweetDTO req){
       repository.save(new Tweet(req));
    }

    @GetMapping
    public List<Tweet> getRecentTweets(@RequestParam(defaultValue = "0") int page){
        // Define o número de tweets por página
        int pageSize = 5;

        // Define o objeto Pageable para a página desejada
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("createdAt").descending());

        // Realiza a consulta paginada e retorna os tweets da página atual
        Page<Tweet> tweetPage = repository.findAllByOrderByCreatedAtDesc(pageable);
        List<Tweet> tweets = tweetPage.getContent();

        return tweets;
    }
    /* public List<Tweet> getAll(){
        List<Tweet> tweets = repository.findAll(); 
        return tweets;
    } */

    @GetMapping("/{username}")
    public List<Tweet> getByUsername(@PathVariable String username){
        List<Tweet> tweets = repository.findByUsername(username); 
        return tweets;
    }

}