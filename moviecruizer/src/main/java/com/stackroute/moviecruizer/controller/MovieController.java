package com.stackroute.moviecruizer.controller;
import com.stackroute.moviecruizer.domain.Movie;
import com.stackroute.moviecruizer.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviecruizer.exceptions.MovieNotFoundException;
import com.stackroute.moviecruizer.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value="api/v1")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }
    private Logger logger = LoggerFactory.getLogger(MovieController.class);

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        logger.info("post mapping movie");
        ResponseEntity responseEntity;
        try{
            movieService.savemovie(movie);
            responseEntity=new ResponseEntity<String>("Success created", HttpStatus.CREATED);

        }catch (MovieAlreadyExistsException ex){
            responseEntity=new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movies")
    public ResponseEntity<?> getAllMovies(){
        logger.info("get all movies");
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }

    @PutMapping(path="/movie/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable ("id") Integer id, @RequestBody Movie movie){
        logger.info("put mapping movie by id");
        Movie fetchedMovie;
        try {
            fetchedMovie=movieService.updateMovie(id,movie);
        } catch (MovieNotFoundException e) {
            return new ResponseEntity<String> (e.getMessage(),HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Movie> (movie,HttpStatus.OK);
    }

    @DeleteMapping(value="/movie/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable("id") int id){
        logger.info("delete mapping by id");
        ResponseEntity responseEntity;
        try {
            movieService.deleteMovieById(id);
            responseEntity = new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping(path="/movie/{id}")
    public ResponseEntity<?> fetchMovieById(@PathVariable("id") int id){
        logger.info("get mapping by id");
        ResponseEntity responseEntity;
        try {
            Movie movie =movieService.getMovieById(id);
            responseEntity = new ResponseEntity<Movie>(movie, HttpStatus.OK);;
        } catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/movie/{movieTitle}")
    public ResponseEntity<?> getMovieByName(@PathVariable("movieTitle") String movieTitle) {
        ResponseEntity responseEntity;
        try {
            Movie movie = movieService.getMovieByName(movieTitle);
            responseEntity = new ResponseEntity<Movie>(movie, HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.OK);
        }
        return responseEntity;
    }

}

