package com.jondrewd.workshopmongo.services;
import com.jondrewd.workshopmongo.domain.Post;
import com.jondrewd.workshopmongo.repository.PostRepository;
import com.jondrewd.workshopmongo.services.exception.ObjectNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

   
    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
    
}
