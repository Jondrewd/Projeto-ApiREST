package com.jondrewd.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jondrewd.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}