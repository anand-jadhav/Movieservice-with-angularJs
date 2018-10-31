import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { MovieDb } from './moviedb';

@Injectable({
  providedIn: 'root'
})
export class MovieserviceService {
  private _url:string = "http://api.themoviedb.org/3/search/movie?api_key=55cf08cf5e5deeeaf83b71f30ef22f53&query=";

  constructor(private http:HttpClient) { }

  getMoviesByName(movieName:string){
    let _url=this._url+movieName;
    return this.http.get(_url).pipe(catchError(this.errorHandler));
  }
   errorHandler(error:HttpErrorResponse){
    return throwError(new Error(error.message));
  }
}