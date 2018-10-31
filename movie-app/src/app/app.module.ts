import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule,Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { SearchmovieComponent } from './searchmovie/searchmovie.component';
import { MovieserviceService } from './movieservice.service';
import {
  MatCardModule,
  MatInputModule,
  MatToolbarModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MoviedetailComponent } from './moviedetail/moviedetail.component';
import { WishlistComponent } from './wishlist/wishlist.component';

const routes: Routes = [
  { path: '', redirectTo: '/movies', pathMatch: 'full' },
  { path: 'wishlist',component:WishlistComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    SearchmovieComponent,
    MoviedetailComponent,
    WishlistComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatCardModule,
    MatInputModule,
    MatToolbarModule,
    RouterModule.forRoot(routes)
  ],
  providers: [MovieserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
