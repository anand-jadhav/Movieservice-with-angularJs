package com.stackroute.moviecruizer.service;
import com.stackroute.moviecruizer.domain.Movie;
import com.stackroute.moviecruizer.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviecruizer.exceptions.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {

    public Movie savemovie(Movie movie) throws MovieAlreadyExistsException;
    Movie updateMovie(int id,Movie movie) throws MovieNotFoundException;
    public List<Movie> getAllMovies();
    boolean deleteMovieById(int id);
    Movie getMovieById(int id);
    public Movie getMovieByName(String movieTitle);

}

