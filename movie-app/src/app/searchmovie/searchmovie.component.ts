import { Component, OnInit } from '@angular/core';
import { MovieserviceService } from '../movieservice.service';
import { MovieDb } from '../moviedb';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-searchmovie',
  templateUrl: './searchmovie.component.html',
  styleUrls: ['./searchmovie.component.css']
})
export class SearchmovieComponent implements OnInit {

  errormsg = "";
  heroes = "";
  movies=[];

  constructor(private movieserviceService: MovieserviceService) { }

  ngOnInit() {

  }
  display(newHero) {
  this.heroes = newHero;
    this.movieserviceService.getMoviesByName(this.heroes).subscribe(
      (data) => this.movies = data['results'],
      (error) => this.errormsg = error
    );
  }

}
