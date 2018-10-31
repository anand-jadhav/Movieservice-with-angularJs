package com.stackroute.moviecruizer.domain;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Document(collection = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    private int id;

    @Size(min=1, message = "too small") private String movieTitle;
    private String comments;
    private String posterPath;
    private String releaseDate;
    @NotNull private String userId;
    private String movieId;

//    public Movie(){
//
//    }
//
//    public Movie(int id, String name, String comments, String posterPath, String releaseDate, String userId, String movieId) {
//        this.id = id;
//        this.name = name;
//        this.comments = comments;
//        this.posterPath = posterPath;
//        this.releaseDate = releaseDate;
//        this.userId = userId;
//        this.movieId = movieId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getMovieId() {
//        return movieId;
//    }
//
//    public void setMovieId(String movieId) {
//        this.movieId = movieId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    public String getPosterPath() {
//        return posterPath;
//    }
//
//    public void setPosterPath(String posterPath) {
//        this.posterPath = posterPath;
//    }
//
//    public String getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//



}
