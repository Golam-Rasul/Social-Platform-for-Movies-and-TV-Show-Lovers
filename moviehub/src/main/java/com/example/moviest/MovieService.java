package com.example.moviest;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;


    public List<Movie> allMovie(){
        List<Movie> movie = repository.findAll();
        return movie;
    }
    public Optional<Movie> singleMovie (String imdbId){
        return repository.findMovieByImdbId(imdbId);
        
    }

}
