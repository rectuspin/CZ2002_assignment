package test;

import model.cinema.Cinema;
import model.cinema.Cineplex;
import model.movie.Movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CinemaTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 30));
        String[] seats = {"A1", "B2", "C3", "D4"};
        Movie terminator = new Movie("Terminator III");
        Cineplex cathay = new Cineplex("Cathay JE");
        cathay.addCinema(new Cinema("Hall 1"));
        cathay.addMovie(terminator);
        cathay.setMovieShowTime(terminator, cathay.getCinema("Hall 1"), now);
        cathay.getCinema("Hall 1").printSeats(now);


        cathay.makeMovieBooking(terminator, cathay.getCinema("Hall 1"), now, seats);
        cathay.getCinema("Hall 1").printSeats(now);


    }
}
