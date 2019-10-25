package model.movie;

import java.time.LocalDateTime;

public class Review {
    LocalDateTime timestamp;
    Integer rating;
    String review = null;
    String nameOfReviewer;
    Movie movie;

    public Review(LocalDateTime timestamp, Integer rating, String review, String nameOfReviewer, Movie movie) {
        this.timestamp = timestamp;
        this.rating = rating;
        this.review = review;
        this.nameOfReviewer = nameOfReviewer;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Review{" +
                "timestamp=" + timestamp +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                ", nameOfReviewer='" + nameOfReviewer + '\'' +
                ", movie=" + movie +
                '}';
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getNameOfReviewer() {
        return nameOfReviewer;
    }

    public void setNameOfReviewer(String nameOfReviewer) {
        this.nameOfReviewer = nameOfReviewer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
