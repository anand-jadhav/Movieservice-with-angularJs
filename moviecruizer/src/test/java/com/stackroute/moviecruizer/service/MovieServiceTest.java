package com.stackroute.moviecruizer.service;

import com.stackroute.moviecruizer.domain.Movie;
import com.stackroute.moviecruizer.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviecruizer.repository.MovieRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    Movie movie;

    //Create a mock for UserRepository
    @Mock//test double
            MovieRepository movieRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    MovieServiceImpl movieService;
    List<Movie> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        movie = new Movie();
        movie.setId(26);
        movie.setMovieTitle("Jonny");
        movie.setComments("Jennyisgood");
        movie.setPosterPath("sadasd123");
        movie.setReleaseDate("123");
        movie.setMovieId("JonnyJohnny");
        movie.setUserId("123123");
        list = new ArrayList<>();
        list.add(movie);


    }

    @Test
    public void saveMovieTestSuccess() throws MovieAlreadyExistsException {

        when(movieRepository.save((Movie)any())).thenReturn(movie);
        Movie savedMovie = movieService.savemovie(movie);
        Assert.assertEquals(movie,savedMovie);

        //verify here verifies that userRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);

    }

    @Test(expected = MovieAlreadyExistsException.class)
    public void saveMovieTestFailure() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie)any())).thenReturn(null);
        Movie savedMovie = movieService.savemovie(movie);
        System.out.println("savedUser" + savedMovie);
        Assert.assertEquals(movie,savedMovie);
//add verify
       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllMovie(){
        movieRepository.save(movie);
        //stubbing the mock to return specific data
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> movielist = movieService.getAllMovies();
        Assert.assertEquals(list,movielist);
        //add verify
    }

    @Test
    public void testDeleteById(){
        movieRepository.save(movie);
        movieRepository.delete(movie);
        Assert.assertEquals(Optional.empty(), movieRepository.findById(movie.getId()));
    }


}
