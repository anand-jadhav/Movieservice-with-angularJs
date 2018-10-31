import { Component, OnInit } from '@angular/core';
import { MovieServiceService } from '../movie.service';
import { Movie } from '../movie';
import { MovieDb } from '../moviedb';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {
  movies:Movie[];
  comments="";

  constructor(private movieService:MovieServiceService,private movieBack:MovieServiceService) { }

  ngOnInit() {
    this.movieService.getMovies().subscribe(
      (data) => this.movies = data);
  }
  deleteMovieByName(mov:Movie): void{
    const id= mov.id;
    this.movies = this.movies.filter(h => h !== mov);
    this.movieService.deleteMovie(id).subscribe();
  }
  // updateMovieByName(mov:Movie,comm): void{
  //   this.comments = comm;
  //   console.log(comm);
  //   const id= mov.id;
  //   this.movies = this.movies;
  //   this.movieService.updateMovie(id).subscribe();
  // }
  public MoviesDb : Movie={
    id:'2',
    movieTitle:'',
    posterPath:'',
    userId:'',
    releaseDate:'',
    comments:'',
    movieId:'movie.comments'
    }

  updateMovieByName(movie:MovieDb,comm){
    this.comments=comm;
    var movieCast={
    "id":movie.id,
    "movieTitle":movie.original_title,
    "posterPath":movie.poster_path,
    "userId":movie.comments,
    "releaseDate":movie.release_date,
    "comments":this.comments,
    "movieId":movie.comments
    }
  
    this.movieBack.updateMovie(movieCast).subscribe(data => this.MoviesDb = data);
    }

}
