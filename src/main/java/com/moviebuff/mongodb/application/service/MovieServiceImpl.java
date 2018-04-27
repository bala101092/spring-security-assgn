package com.moviebuff.mongodb.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebuff.mongodb.application.Exception.MovieBuffServiceException;
import com.moviebuff.mongodb.application.Exception.MovieNotFoundException;
import com.moviebuff.mongodb.application.entity.Movies;
import com.moviebuff.mongodb.application.repository.MovieRepository;

/**
 * @author Balamurugan M
 *
 */
@Service
public class MovieServiceImpl implements MovieService {
	
	private MovieRepository movieRepository;
	
	/**
	 * @param movieRepository
	 */
	@Autowired	
	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	/* (non-Javadoc)
	 * @see com.moviebuff.mongodb.application.service.MovieService#create(com.moviebuff.mongodb.application.entity.Movies)
	 */
	public Movies create(Movies movie) throws MovieBuffServiceException {
		
		try {
			return movieRepository.save(movie);
		} catch (Exception e) {
			 throw new MovieBuffServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.moviebuff.mongodb.application.service.MovieService#delete(java.lang.String)
	 */
	public Movies delete(String id) throws MovieBuffServiceException {
		
		try {
			Movies movie = findMovieById(id);
			return movieRepository.delete(movie);
		} catch (MovieNotFoundException e) {
			throw new MovieBuffServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.moviebuff.mongodb.application.service.MovieService#findAll()
	 */
	public List<Movies> findAll() throws MovieBuffServiceException {
		
		try {
			return movieRepository.findAll();
		} catch (Exception e) {
			throw new MovieBuffServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.moviebuff.mongodb.application.service.MovieService#findById(java.lang.String)
	 */
	public Movies findById(String id) throws MovieBuffServiceException {
		
		try {
			return findMovieById(id);
		} catch (MovieNotFoundException e) {
			throw new MovieBuffServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.moviebuff.mongodb.application.service.MovieService#update(com.moviebuff.mongodb.application.entity.Movies)
	 */
	public Movies update(Movies movie) throws MovieBuffServiceException {
		
		try {
			return movieRepository.save(movie);
		} catch (Exception e) {
			 throw new MovieBuffServiceException(e);
		}
	}
	
	/**
	 * @param id
	 * @return
	 * @throws MovieNotFoundException
	 */
	private Movies findMovieById(String id) throws MovieNotFoundException {
        Optional<Movies> result = movieRepository.findOne(id);
        return result.orElseThrow(() -> new MovieNotFoundException(id));
 
    }

}
