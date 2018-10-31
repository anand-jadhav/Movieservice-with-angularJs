package com.stackroute.moviecruizer.service;

import com.stackroute.moviecruizer.domain.Movie;
import com.stackroute.moviecruizer.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviecruizer.exceptions.MovieNotFoundException;
import com.stackroute.moviecruizer.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Qualifier("imp1")
public class MovieServiceImpl implements MovieService {

    Logger logger_one = LoggerFactory.getLogger(MovieServiceImpl.class);
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    @Override
    public Movie savemovie(Movie movie) throws MovieAlreadyExistsException {

        logger_one.info("Save a movie function in impl1");

        if(movieRepository.existsById(movie.getId())){
            throw new MovieAlreadyExistsException("Movie already exists");
        }

        Movie savedMovie=movieRepository.save(movie);

        if(savedMovie == null){
            throw new MovieAlreadyExistsException("Movie already exists");
        }

        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public boolean deleteMovieById(int id) {

        logger_one.info("Get all the movies function in impl1");

        final Movie movie = movieRepository.findById(id).orElse(null);
        movieRepository.delete(movie);
        return true;

    }

    public Movie updateMovie(int id,Movie updateMovie) throws MovieNotFoundException{

        logger_one.info("Update a movie function in impl1");

        final Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            throw new MovieNotFoundException("Couldn't update movie. Movie not found!");
        }
        movie.setComments(updateMovie.getComments());
        movieRepository.save(movie);
        return movie;

    }


    public Movie getMovieById(int id) {

        logger_one.info("Get a movie by id function in impl1");

        final Movie movie = movieRepository.findById(id).get();
        return movie;
    }

    public Movie getMovieByName(String movieTitle){
        Movie movie=movieRepository.findByMovieTitle(movieTitle);
        return movie;
    }

}
