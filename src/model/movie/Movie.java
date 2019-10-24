package model.movie;

import java.util.ArrayList;
import java.util.UUID;

public class Movie {
    private UUID uuid;
    private String title;
    private MovieStatus movieStatus = MovieStatus.ComingSoon;
    private String director = null;
    private ArrayList<String> cast;
    private Float overallRating = null;
    private ArrayList[] pastRatingsAndReviews = new ArrayList[5];


    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, MovieStatus movieStatus, String director, ArrayList cast) {
        this.title = title;
        this.uuid = UUID.fromString(title);
        this.movieStatus = movieStatus;
        this.director = director;
        this.cast = cast;
    }

    public Movie(String title, MovieStatus movieStatus, String director, ArrayList cast, boolean threeD) {
        this.title = title;
        this.movieStatus = movieStatus;
        this.director = director;
        this.cast = cast;

    }

    // getter and setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieStatus getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
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

    public float getOverallRating() {
        return overallRating;
    }

    public ArrayList[] getPastRatingsAndReviews() {
        return pastRatingsAndReviews;
    }


    public void setPastRatingsAndReviews(ArrayList[] pastRatingsAndReviews) {
        this.pastRatingsAndReviews = pastRatingsAndReviews;
    }


    // other methods
    public void addMovieRating(MovieRating movieRating) {
        pastRatingsAndReviews[movieRating.getMovieRatingCode() - 1].add(" ");
    }

    public void addMovieRating(MovieRating movieRating, String review) {
        pastRatingsAndReviews[movieRating.getMovieRatingCode() - 1].add(review);
    }

    public void updateMovieRating() {
        int sumOfRatings = 0;
        int totalReviews = 0;
        for (int i = 0; i < pastRatingsAndReviews.length; i++) {
            sumOfRatings += pastRatingsAndReviews[i].size() * (i + 1);
            totalReviews += pastRatingsAndReviews[i].size();
        }
        overallRating = (float) (sumOfRatings / totalReviews);
    }

    public void addCast(String castName) {
        cast.add(castName);
    }

    public void removeCast(String castName) {
        cast.remove(castName);
    }


}
