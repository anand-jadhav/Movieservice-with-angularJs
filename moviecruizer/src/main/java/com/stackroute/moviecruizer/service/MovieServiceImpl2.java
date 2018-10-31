//package com.stackroute.moviecruizer.service;
//
//import com.stackroute.moviecruizer.domain.Movie;
//import com.stackroute.moviecruizer.exceptions.MovieAlreadyExistsException;
//import com.stackroute.moviecruizer.exceptions.MovieNotFoundException;
//import com.stackroute.moviecruizer.repository.MovieRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import java.util.List;
//
//@Qualifier("imp2")
//public class MovieServiceImpl2 implements MovieService{
//    Logger logger_two = LoggerFactory.getLogger(MovieServiceImpl2.class);
//    MovieRepository movieRepository;
//
//    @Autowired
//    public MovieServiceImpl2(MovieRepository movieRepository){
//        this.movieRepository=movieRepository;
//    }
//
//    @Override
//    public Movie savemovie(Movie movie) throws MovieAlreadyExistsException {
//
//        logger_two.info("Save a movie function in impl2");
//
//        if(movieRepository.existsById(movie.getId())){
//            throw new MovieAlreadyExistsException("Movie already exists");
//        }
//
//        Movie savedMovie=movieRepository.save(movie);
//
//        if(savedMovie == null){
//            throw new MovieAlreadyExistsException("Movie already exists");
//        }
//
//        return savedMovie;
//    }
//
//    @Override
//    public List<Movie> getAllMovies() {
//        return movieRepository.findAll();
//    }
//
//    public boolean deleteMovieById(int id) {
//
//        logger_two.info("Delete a movie function in impl2");
//
//        final Movie movie = movieRepository.findById(id).orElse(null);
//        movieRepository.delete(movie);
//        return true;
//
//    }
//
//    public Movie updateMovie(int id,Movie updateMovie) throws MovieNotFoundException {
//
//        logger_two.info("Update a movie function in impl2");
//
//        final Movie movie = movieRepository.findById(id).orElse(null);
//        if (movie == null) {
//            throw new MovieNotFoundException("Couldn't update movie. Movie not found!");
//        }
//        movie.setComments(updateMovie.getComments());
//        movieRepository.save(movie);
//        return movie;
//
//    }
//
//
//    public Movie getMovieById(int id) {
//
//        logger_two.info("Get a movie function in impl2");
//
//        final Movie movie = movieRepository.findById(id).get();
//        return movie;
//    }
//
//    //public List<Movie> searchByMovieQuery(String name){
//        //return (List)movieRepository.getMovieByTitle(name);
//    //}
//}
