import { Component, OnInit,Input } from '@angular/core';
import { MovieServiceService } from '../movie.service';
import { MovieDb } from '../moviedb';
import { Movie } from '../movie';

@Component({
  selector: 'app-moviedetail',
  templateUrl: './moviedetail.component.html',
  styleUrls: ['./moviedetail.component.css']
})
export class MoviedetailComponent implements OnInit {
  @Input('search') movies;
  constructor(private movieBack:MovieServiceService) { }

  ngOnInit() {
  }
addMovie(movie:MovieDb){
  var movieCast={
  "id":movie.id,
  "movieTitle":movie.original_title,
  "posterPath":movie.poster_path,
  "userId":movie.comments,
  "releaseDate":movie.release_date,
  "comments":movie.overview,
  "movieId":movie.comments
  }
  // var movieCast:Movie;
  // movieCast.id=movie.id;
  // movieCast.movieTitle=movie.original_title;
  // movieCast.posterUrl=movie.poster_path;
  // movieCast.rating=movie.vote_average;
  // movieCast.yearOfRelease=movie.release_date;
  // movieCast.comments=movie.overview;

  this.movieBack.addMovie(movieCast).subscribe();
  }
}
