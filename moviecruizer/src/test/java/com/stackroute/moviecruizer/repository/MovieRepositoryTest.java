package com.stackroute.moviecruizer.repository;


import com.stackroute.moviecruizer.domain.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


//This is integrated test we need DB server
@RunWith(SpringRunner.class)
@DataMongoTest
//@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;


    Movie movie;

    @Before
    public void setUp()
    {
        movie = new Movie();
        movie.setId(26);
        movie.setMovieTitle("Jonny");
        movie.setComments("Jennyisgood");
        movie.setPosterPath("sadasd123");
        movie.setReleaseDate("123");
        movie.setMovieId("JonnyJohnny");
        movie.setUserId("123123");

    }

    @After
    public void tearDown(){
        movieRepository.deleteAll();
    }


    @Test
    public void testSaveMovie(){
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertEquals(26,fetchMovie.getId());

    }

    @Test
    public void testSaveMovieFailure(){
        Movie testMovie = new Movie(26,"Jonny","Jennyisgood","sadasd123","123","JonnyJohnny","123123");
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertNotSame(movie,fetchMovie);
    }

    @Test
    public void testGetAllMovie(){
        Movie u = new Movie(5,"Johnny","comments1","a","a","a","a");
        Movie u1 = new Movie(8,"Johnny","comments1","a","a","a","a");
        movieRepository.save(u);
        movieRepository.save(u1);

        List<Movie> list = movieRepository.findAll();
        Assert.assertEquals("Johnny",list.get(0).getMovieTitle());
    }

    @Test

    public void testSearch(){
        Movie mov1 = new Movie(9,"Johnnydfg","commentsdgf1","ahgh","aaa","aew","as");
        Movie mov2 = new Movie(8,"Johnnyfdf","comments1sdf","adf","asf","asdf","a");
        movieRepository.save(mov1);
        Movie fetchmovie = movieRepository.findById(mov1.getId()).get();
        Assert.assertEquals(9 , fetchmovie.getId());
    }

    @Test
    public void testDeleteById(){
        movieRepository.save(movie);
        movieRepository.delete(movie);
        Assert.assertEquals(Optional.empty(), movieRepository.findById(movie.getId()));
    }



}


