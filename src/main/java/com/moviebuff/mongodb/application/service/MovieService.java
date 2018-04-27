package com.moviebuff.mongodb.application.service;

import java.util.List;

import com.moviebuff.mongodb.application.Exception.MovieBuffServiceException;
import com.moviebuff.mongodb.application.entity.Movies;

public interface MovieService {
	
	Movies create(Movies todo) throws MovieBuffServiceException;
	 
    Movies delete(String id) throws MovieBuffServiceException;
 
    List<Movies> findAll() throws MovieBuffServiceException;
 
    Movies findById(String id) throws MovieBuffServiceException;
 
    Movies update(Movies todo) throws MovieBuffServiceException;

}
