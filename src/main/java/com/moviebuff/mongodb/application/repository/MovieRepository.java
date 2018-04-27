package com.moviebuff.mongodb.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.moviebuff.mongodb.application.entity.Movies;

public interface MovieRepository extends Repository<Movies, String> {

	Movies delete(Movies deleted);
	 
    List<Movies> findAll();
 
    Optional<Movies> findOne(String id);
 
    Movies save(Movies saved);
    
}
