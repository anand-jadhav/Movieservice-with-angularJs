package com.stackroute.moviecruizer;

import com.stackroute.moviecruizer.domain.Movie;
import com.stackroute.moviecruizer.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class MoviecruizerApplication {

    static Logger logger = LoggerFactory.getLogger(MoviecruizerApplication.class);
	/**
	 * This event is executed as late as conceivably possible to indicate that
	 * the application is ready to service requests.
	 */
/*

	@Autowired
	private MovieRepository movieRepository;
*/

//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		Movie movie = new Movie(5,"ethi5","comments1","a","a","a","a");
//		movieRepository.save(movie);
//		Movie movie2 = new Movie(6,"ethi6","comments2","b","b","b","b");
//		movieRepository.save(movie2);
//	}
//	@Override
//	public void run(String... args){
//		Movie movie = new Movie(7,"ethi6","comments3","c","c","c","c");
//		movieRepository.save(movie);
//		Movie movie2 = new Movie(8,"ethi8","comments4","d","d","d","d");
//		movieRepository.save(movie2);
//	}

	public static void main(String[] args) {
		logger.info("Programme started today");
	    SpringApplication.run(MoviecruizerApplication.class, args);
	}
}
