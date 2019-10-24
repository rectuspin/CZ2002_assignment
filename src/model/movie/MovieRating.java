package model.movie;

public enum MovieRating {
    NullRating(0),
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5);

    private final int movieRating;

    MovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public int getMovieRatingCode() {
        return movieRating;
    }
}
