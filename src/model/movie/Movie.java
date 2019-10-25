package model.movie;

import java.util.ArrayList;

public class Movie {
    //    private UUID uuid;
    private String title;
    private String director;
    private ArrayList<String> cast;
    private String synopsis;
    private MovieStatus movieStatus;
    private Float overallRating = null;
    private ArrayList<Review> reviews;

    public Movie(String title, String director, ArrayList<String> cast, String synopsis) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.synopsis = synopsis;
        this.movieStatus = MovieStatus.ComingSoon;
        reviews = new ArrayList<>();
    }

    public Movie(String title, String director, ArrayList<String> cast, String synopsis, MovieStatus movieStatus) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.synopsis = synopsis;
        this.movieStatus = movieStatus;
        reviews = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public MovieStatus getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    public Float getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Float overallRating) {
        this.overallRating = overallRating;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", cast=" + cast +
                ", synopsis='" + synopsis + '\'' +
                ", movieStatus=" + movieStatus +
                ", overallRating=" + overallRating +
                ", reviews=" + reviews +
                '}';
    }
}
