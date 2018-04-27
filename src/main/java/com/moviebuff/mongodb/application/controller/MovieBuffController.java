package com.moviebuff.mongodb.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moviebuff.mongodb.application.Exception.MovieBuffControllerExeption;
import com.moviebuff.mongodb.application.Exception.MovieBuffServiceException;
import com.moviebuff.mongodb.application.entity.Movies;
import com.moviebuff.mongodb.application.service.MovieService;

/**
 * @author Balamurugan M
 *
 */
@RestController
@RequestMapping("/secure/api/movies")
public class MovieBuffController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieBuffController.class);
	
	private MovieService movieService;

	/**
	 * @param movieService
	 */
	@Autowired
	public MovieBuffController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	/**
	 * @param todoEntry
	 * @return Movies
	 * @throws MovieBuffControllerExeption
	 */
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Movies create(@RequestBody @Valid Movies todoEntry) throws MovieBuffControllerExeption {
        try {
			return movieService.create(todoEntry);
		} catch (MovieBuffServiceException e) {
			throw new MovieBuffControllerExeption(e);
		}
    }
 
    /**
     * @param id
     * @return Movies
     * @throws MovieBuffControllerExeption
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    Movies delete(@PathVariable("id") String id) throws MovieBuffControllerExeption {
        try {
			return movieService.delete(id);
		} catch (MovieBuffServiceException e) {
			throw new MovieBuffControllerExeption(e);
		}
    }
 
    /**
     * @return List<Movies>
     * @throws MovieBuffControllerExeption
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Movies> findAll() throws MovieBuffControllerExeption {
        try {
			return movieService.findAll();
		} catch (MovieBuffServiceException e) {
			throw new MovieBuffControllerExeption(e);
		}
    }
 
    /**
     * @param id
     * @return Movies
     * @throws MovieBuffControllerExeption
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Movies findById(@PathVariable("id") String id) throws MovieBuffControllerExeption {
        try {
			return movieService.findById(id);
		} catch (MovieBuffServiceException e) {
			throw new MovieBuffControllerExeption(e);
		}
    }
 
    /**
     * @param todoEntry
     * @return Movies
     * @throws MovieBuffControllerExeption
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Movies update(@RequestBody @Valid Movies todoEntry) throws MovieBuffControllerExeption {
        try {
			return movieService.update(todoEntry);
		} catch (MovieBuffServiceException e) {
			throw new MovieBuffControllerExeption(e);
		}
    }
 
    /**
     * @param ex
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(MovieBuffControllerExeption ex) {
    	LOGGER.error("ExceptionHandler message : " + ex.getMessage());
    }

}
