package com.stackroute.moviecruizer.repository;

import com.stackroute.moviecruizer.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MovieRepository extends MongoRepository<Movie,Integer> {
//    @Query(value="select * from MOVIE o where o.name=:name count ")
      public Movie findByMovieTitle(String movieTitle);
}
