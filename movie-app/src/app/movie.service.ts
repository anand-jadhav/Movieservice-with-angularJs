import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Movie } from './movie';
import { catchError } from 'rxjs/operators'

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class MovieServiceService implements OnInit {
  url = "/movie/api/v1/movies";
  deleteUrl ="/movie/api/v1/movie/";
  addUrl="/movie/api/v1/movie";
  constructor(private httpClient: HttpClient) {
  }
  ngOnInit() { }

  //getting all movies
  getMovies(): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>(this.url).pipe(catchError(this.errorHandler));
  }

  // saving movie
  addMovie(movie:object): Observable<Movie> {
    return this.httpClient.post<Movie>(this.addUrl, movie, httpOptions)
      .pipe(catchError(this.errorHandler));
  }
  // update movie
  updateMovie(movie:any): Observable<Movie>{
    return this.httpClient.put<Movie>(this.addUrl+"/"+movie.id , movie ,httpOptions).pipe(
      catchError(this.errorHandler)
    );
  }

  // delete Movie
  deleteMovie(id: string):Observable<string>{
    console.log(id);
    const url2= `${this.deleteUrl}${id}`;
    return this.httpClient.delete<string>(url2,httpOptions).pipe(
      catchError(this.errorHandler)
    );
  }
  
  // Error  Handling
  errorHandler(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };
}