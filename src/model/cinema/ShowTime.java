package model.cinema;

import model.movie.Language;
import model.movie.Movie;
import model.movie.MovieType;
import model.movie.Subtitle;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class ShowTime {

    private Movie movie;

    private LocalDate dateOfMovie;

    private LocalTime timeOfMovie;

    private HashMap<Character, Seat[]> seatLayout;

    private Cinema cinema;

    private Cineplex cineplex;

    private Language language;

    private Subtitle subtitle;

    private MovieType movieType;

    public ShowTime(Movie movie, LocalDate dateOfMovie, LocalTime timeOfMovie, HashMap<Character, Seat[]> seatLayout,
                    Cineplex cineplex, Cinema cinema, Language language, Subtitle subtitle, MovieType movieType) {
        this.movie = movie;
        this.dateOfMovie = dateOfMovie;
        this.timeOfMovie = timeOfMovie;
        this.seatLayout = seatLayout;
        this.cinema = cinema;
        this.language = language;
        this.subtitle = subtitle;
        this.movieType = movieType;
    }

    public ShowTime(Movie movie, LocalDate dateOfMovie, LocalTime timeOfMovie, HashMap<Character, Seat[]> seatLayout,
                    Cineplex cineplex, Cinema cinema) {
        this.movie = movie;
        this.dateOfMovie = dateOfMovie;
        this.timeOfMovie = timeOfMovie;
        this.seatLayout = seatLayout;
        this.cinema = cinema;
        this.language = Language.ENGLISH;
        this.subtitle = Subtitle.None;
        this.movieType = MovieType.DIGITAL;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getDateOfMovie() {
        return dateOfMovie;
    }

    public void setDateOfMovie(LocalDate dateOfMovie) {
        this.dateOfMovie = dateOfMovie;
    }

    public LocalTime getTimeOfMovie() {
        return timeOfMovie;
    }

    public void setTimeOfMovie(LocalTime timeOfMovie) {
        this.timeOfMovie = timeOfMovie;
    }

    public HashMap<Character, Seat[]> getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(HashMap<Character, Seat[]> seatLayout) {
        this.seatLayout = seatLayout;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    @Override
    public String toString() {
        return "ShowTime{" +
                "movie=" + movie +
                ", dateOfMovie=" + dateOfMovie +
                ", timeOfMovie=" + timeOfMovie +
                ", seatLayout=" + seatLayout +
                ", cinema=" + cinema +
                ", cineplex=" + cineplex +
                ", language=" + language +
                ", subtitle=" + subtitle +
                ", movieType=" + movieType +
                '}';
    }
}
